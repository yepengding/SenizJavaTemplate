package org.veritasopher.senizjava.blockwriting.worker.core;

import org.veritasopher.senizjava.blockwriting.core.GlobalVariable;
import org.veritasopher.senizjava.blockwriting.worker.base.ActionExecutor;
import org.veritasopher.senizjava.blockwriting.worker.base.StateBehavior;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static org.veritasopher.senizjava.blockwriting.worker.core.Variable.LOC;

public enum State implements StateBehavior {
    processing() {
        @Override
        public void init(Map<Variable, Object> varSet,
                         ConcurrentMap<Argument, Object> argSet,
                         ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 1);
        }

        @Override
        public State next(ActionExecutor exec,
                          Map<Variable, Object> varSet,
                          ConcurrentMap<Argument, Object> argSet,
                          ConcurrentMap<GlobalVariable, Object> gVarSet) {
            return readyToWrite;
        }
    },


    readyToWrite() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 2);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            if (((int) gVarSet.get(GlobalVariable.S) > 0)) {
                exec.writeBlock();
                return written;
            }

            return readyToWrite;
        }
    },

    written() {
        @Override
        public void init(Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
            varSet.put(LOC, 3);
        }

        @Override
        public State next(ActionExecutor exec, Map<Variable, Object> varSet, ConcurrentMap<Argument, Object> argSet, ConcurrentMap<GlobalVariable, Object> gVarSet) {
//            return processing;
            return null;
        }
    },

}
