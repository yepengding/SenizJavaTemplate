package org.veritasopher.senizjava.semaphore.sdk;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class SystemExecutorThread<G> implements Callable<Void> {

    protected final String id;
    protected final ConcurrentMap<G, Object> globalVariableSet;

    public SystemExecutorThread() {
        this.id = null;
        this.globalVariableSet = new ConcurrentHashMap<>();
    }

    public SystemExecutorThread(String id, ConcurrentMap<G, Object> globalVariableSet) {
        this.id = id;
        this.globalVariableSet = globalVariableSet;
    }

    public void run() {

    }

    @Override
    public Void call() {
        this.run();
        return null;
    }
}
