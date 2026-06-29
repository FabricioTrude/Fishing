package com.fabricio.fishing.event;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final Map<Class<?>, List<Listener<?>>> listeners = new HashMap<>();

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
}
