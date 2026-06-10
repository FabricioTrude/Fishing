package com.fabricio.fishing.event;

import java.util.*;

public class EventBus {
    private final Map<Class<?>, List<Listener<?>>> listeners = new HashMap<>();

    public <T> void register(Class<T> type, Listener<T> listener){
        listeners.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
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
