package org.veritasopher.senizjava.fsm;

import org.veritasopher.senizjava.fsm.core.State;
import org.veritasopher.senizjava.fsm.core.Variable;

import java.util.HashMap;
import java.util.Map;

public class SystemExecutor {

    private final Map<Variable, Object> variableSet;

    private final ActionEffect actionEffect;

    public SystemExecutor() {
        this.variableSet = new HashMap<>();
        this.actionEffect = new ActionEffect();
        this.actionEffect.setVariableSet(variableSet);
    }

    public void run() {
        State state = State.s0;
        while (state != null) {
            state.init(variableSet);
            state = state.next(actionEffect);
        }
    }

}
