package org.veritasopher.senizjava.semaphore.program.sdk;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.ActionEffect;
import org.veritasopher.senizjava.semaphore.program.core.Argument;
import org.veritasopher.senizjava.semaphore.program.core.Variable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class SystemExecutorThread<T> implements Callable<Void> {

    protected final Map<Variable, Object> variableSet;
    protected final ConcurrentMap<Argument, Object> argumentSet;

    protected final ActionEffect actionEffect;

    protected final String id;
    protected final ConcurrentMap<T, Object> globalVariableSet;

    public SystemExecutorThread() {
        this.variableSet = new HashMap<>();
        this.argumentSet = new ConcurrentHashMap<>();

        this.actionEffect = new ActionEffect();
        this.actionEffect.setVariableSet(variableSet);
        this.actionEffect.setArgumentSet(argumentSet);

        this.id = null;
        this.globalVariableSet = new ConcurrentHashMap<>();
    }

    public SystemExecutorThread(String id, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<T, Object> globalVariableSet) {
        this.variableSet = new HashMap<>();
        this.argumentSet = argumentSet;

        this.actionEffect = new ActionEffect();
        this.actionEffect.setVariableSet(variableSet);
        this.actionEffect.setArgumentSet(argumentSet);

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
