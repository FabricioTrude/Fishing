package com.fabricio.fishing.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBus {
    private final List<Consumer<Event>> listeners = new ArrayList<>();

    public void subscribe(Consumer<Event> listener){
        listeners.add(listener);
    }

    public void publish(Event event){
        for(Consumer<Event> l : listeners){
            l.accept(event);
        }
    }
}
