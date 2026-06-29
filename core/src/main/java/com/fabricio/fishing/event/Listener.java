package com.fabricio.fishing.event;

@FunctionalInterface
public interface Listener<T> {
    void onEvent(T event);
}
