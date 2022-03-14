package org.veritasopher.senizjava.fsm.core;

import org.veritasopher.senizjava.fsm.base.ActionExecutor;
import org.veritasopher.senizjava.fsm.base.StateBehavior;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static org.veritasopher.senizjava.fsm.core.Variable.FLAG;
import static org.veritasopher.senizjava.fsm.core.Variable.STATUS;

public enum State implements StateBehavior {

    s0() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            varSet.put(STATUS, 0);
            varSet.put(FLAG, false);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            exec.a0();
            return s1;
        }
    },
    s1() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            varSet.put(STATUS, 1);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            exec.a1();
            return s2;
        }
    },
    s2() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            varSet.put(STATUS, 2);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<?, Object> gVarSet) {
            return null;
        }
    }

}
