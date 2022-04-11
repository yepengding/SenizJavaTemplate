package org.veritasopher.senizjava.semaphore.program;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.core.Argument;
import org.veritasopher.senizjava.semaphore.program.core.State;
import org.veritasopher.senizjava.semaphore.sdk.Sync;
import org.veritasopher.senizjava.semaphore.program.sdk.SystemExecutorThread;

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
        State state = State.plain;
        while (state != null) {
            Sync.lock.lock();
            state.init(variableSet, argumentSet, globalVariableSet);
            state = state.next(actionEffect, variableSet, argumentSet, globalVariableSet);
            Sync.lock.unlock();
        }
    }

}
