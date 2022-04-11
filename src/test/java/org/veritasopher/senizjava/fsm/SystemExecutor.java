package org.veritasopher.senizjava.fsm;

import org.veritasopher.senizjava.fsm.core.State;
import org.veritasopher.senizjava.fsm.sdk.Sync;
import org.veritasopher.senizjava.fsm.sdk.SystemExecutorThread;
import org.veritasopher.senizjava.fsm.core.GlobalVariable;
import org.veritasopher.senizjava.fsm.core.Argument;
import org.veritasopher.senizjava.fsm.core.Variable;

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
        State state = State.s0;
        while (state != null) {
            Sync.lock.lock();
            state.init(variableSet, argumentSet, globalVariableSet);
            state = state.next(actionEffect, variableSet, argumentSet, globalVariableSet);
            Sync.lock.unlock();
        }
    }

}
