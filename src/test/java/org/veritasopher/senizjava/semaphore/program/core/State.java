package org.veritasopher.senizjava.semaphore.program.core;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.base.ActionExecutor;
import org.veritasopher.senizjava.semaphore.program.base.StateBehavior;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static org.veritasopher.senizjava.semaphore.program.core.Variable.LOC;

public enum State implements StateBehavior {
    plain() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 1);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            return wait;
        }
    },

    wait() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 2);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            if ((1 > 0)) {
                exec.enterCritical();
                return critical;
            } else {
                return wait;
            }
        }
    },

    critical() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 3);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            exec.exitCritical();
            return null;
        }
    }

}
