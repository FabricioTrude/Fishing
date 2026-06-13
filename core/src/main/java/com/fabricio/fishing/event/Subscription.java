package com.fabricio.fishing.event;

public class Subscription {
    private final Runnable unsubscribe;

    public Subscription(Runnable unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    public void unsubscribe(){
        unsubscribe.run();
    }
}
