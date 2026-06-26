package com.fabricio.fishing.event;

import com.fabricio.fishing.event.annotations.Subscribe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final Map<Class<?>, List<Listener<?>>> listeners = new HashMap<>();
    private final Map<Object, List<Registration>> owners = new HashMap<>();

    public void register(Object o) {
        List<Registration> regs = new ArrayList<>();

        for (var m : o.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Subscribe.class)) continue;
            if (m.getParameterCount() != 1) continue;

            Class<?> type = m.getParameterTypes()[0];
            m.setAccessible(true);

            Listener<Object> listener = event -> {
                try {
                    m.invoke(o, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            listeners
                .computeIfAbsent(type, k -> new ArrayList<>())
                .add(listener);

            regs.add(new Registration(type, listener));
        }

        owners.put(o, regs);
    }

    public void unregister(Object o) {
        List<Registration> regs = owners.remove(o);
        if (regs == null) return;

        for (Registration r : regs) {
            List<Listener<?>> list = listeners.get(r.type);
            if (list != null) {
                list.remove(r.listener);
                if (list.isEmpty()) listeners.remove(r.type);
            }
        }
    }

    public <T> Subscription register(Class<T> type, Listener<T> listener){
        listeners.computeIfAbsent(type, k -> new CopyOnWriteArrayList<>()).add(listener);
        return new Subscription(() -> unregister(type, listener));
    }


    public <T> void unregister(Class<T> type, Listener<? super T> listener){
        List<Listener<?>> list = listeners.get(type);
        if(list == null) return;
        list.remove(listener);
        if(list.isEmpty())listeners.remove(type);
    }

    @SuppressWarnings("unchecked")
    public <T> void post(T event){
        List<Listener<?>> list =  listeners.get(event.getClass());
        if(list == null) return;
        for(Listener<?> listener : list)((Listener<T>)listener).onEvent(event);
    }

    record Registration(Class<?> type, Listener<?> listener) {
    }
}
