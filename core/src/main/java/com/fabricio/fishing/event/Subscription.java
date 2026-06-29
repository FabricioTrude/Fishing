package com.fabricio.fishing.event;

public class Subscription implements AutoCloseable{
    private final Runnable unsubscribe;

    public Subscription(Runnable unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    @Override
    public void close() throws Exception {
        unsubscribe.run();
    }
}
