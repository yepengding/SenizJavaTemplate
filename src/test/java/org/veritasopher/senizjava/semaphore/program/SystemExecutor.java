package org.veritasopher.senizjava.semaphore.program;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.core.Argument;
import org.veritasopher.senizjava.semaphore.program.core.State;
import org.veritasopher.senizjava.semaphore.program.core.Variable;
import org.veritasopher.senizjava.semaphore.sdk.Sync;
import org.veritasopher.senizjava.semaphore.sdk.SystemExecutorThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SystemExecutor extends SystemExecutorThread<GlobalVariable> {

    private final Map<Variable, Object> variableSet;
    private final ConcurrentMap<Argument, Object> argumentSet;

    private final ActionEffect actionEffect;

    public SystemExecutor() {
        super();
        this.variableSet = new HashMap<>();
        this.argumentSet = new ConcurrentHashMap<>();

        this.actionEffect = new ActionEffect();
        this.actionEffect.setVariableSet(variableSet);
        this.actionEffect.setArgumentSet(argumentSet);
    }

    public SystemExecutor(String id, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
        super(id, gVarSet);
        this.variableSet = new HashMap<>();
        this.argumentSet = argSet;

        this.actionEffect = new ActionEffect();
        this.actionEffect.setVariableSet(variableSet);
        this.actionEffect.setArgumentSet(argumentSet);
    }

    @Override
    public void run() {
        System.out.println("Running " + id);
        State state = State.plain;
        while (state != null) {
            Sync.lock.lock();
            state.init(variableSet, argumentSet, globalVariableSet);
            state = state.next(actionEffect, variableSet, argumentSet, globalVariableSet);
            Sync.lock.unlock();
        }
    }

}
