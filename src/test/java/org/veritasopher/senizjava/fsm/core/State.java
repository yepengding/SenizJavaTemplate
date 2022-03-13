package org.veritasopher.senizjava.fsm.core;

import org.veritasopher.senizjava.fsm.base.ActionExecutor;
import org.veritasopher.senizjava.fsm.base.StateBehavior;

import java.util.Map;

import static org.veritasopher.senizjava.fsm.core.Argument.ARG0;
import static org.veritasopher.senizjava.fsm.core.Variable.FLAG;
import static org.veritasopher.senizjava.fsm.core.Variable.STATUS;

public enum State implements StateBehavior {

    s0() {
        @Override
        public void init(Map<Variable, Object> varSet) {
            varSet.put(STATUS, ARG0.getValue());
            varSet.put(FLAG, false);
        }

        @Override
        public State next(ActionExecutor exec) {
            exec.a0();
            return s1;
        }
    },
    s1() {
        @Override
        public void init(Map<Variable, Object> varSet) {
            varSet.put(STATUS, 1);
        }

        @Override
        public State next(ActionExecutor exec) {
            exec.a1();
            return s2;
        }
    },
    s2() {
        @Override
        public void init(Map<Variable, Object> varSet) {
            varSet.put(STATUS, 2);
        }

        @Override
        public State next(ActionExecutor exec) {
            return null;
        }
    }

}
