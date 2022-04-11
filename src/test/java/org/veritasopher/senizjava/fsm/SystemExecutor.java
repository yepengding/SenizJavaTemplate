package org.veritasopher.senizjava.fsm;

import org.veritasopher.senizjava.fsm.core.Argument;
import org.veritasopher.senizjava.fsm.core.State;
import org.veritasopher.senizjava.fsm.sdk.Sync;
import org.veritasopher.senizjava.fsm.sdk.SystemExecutorThread;

import java.util.concurrent.ConcurrentMap;

public class SystemExecutor extends SystemExecutorThread<Void> {

    public SystemExecutor() {
        super();
    }

    public SystemExecutor(String id, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<Void, Object> globalVariableSet) {
        super(id, argumentSet, globalVariableSet);
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
