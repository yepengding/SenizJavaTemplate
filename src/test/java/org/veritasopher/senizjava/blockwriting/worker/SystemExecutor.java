package org.veritasopher.senizjava.blockwriting.worker;

import org.veritasopher.senizjava.blockwriting.core.GlobalVariable;
import org.veritasopher.senizjava.blockwriting.sdk.Sync;
import org.veritasopher.senizjava.blockwriting.sdk.SystemExecutorThread;
import org.veritasopher.senizjava.blockwriting.worker.core.Argument;
import org.veritasopher.senizjava.blockwriting.worker.core.State;

import java.util.concurrent.ConcurrentMap;

public class SystemExecutor extends SystemExecutorThread<GlobalVariable> {

    public SystemExecutor() {
        super();
    }

    public SystemExecutor(String id, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
        super(id, argSet, gVarSet);
    }

    @Override
    public void run() {
        System.out.println("Running " + id);
        State state = State.processing;
        while (state != null) {
            Sync.lock.lock();
            state.init(variableSet, argumentSet, globalVariableSet);
            state = state.next(actionEffect, variableSet, argumentSet, globalVariableSet);
            Sync.lock.unlock();
        }
    }

}
