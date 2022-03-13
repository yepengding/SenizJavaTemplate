package org.veritasopher.senizjava.fsm.base;

import org.veritasopher.senizjava.fsm.core.State;
import org.veritasopher.senizjava.fsm.core.Variable;

import java.util.Map;

public interface StateBehavior {

    void init(Map<Variable, Object> variableSet);

    State next(ActionExecutor executor);

}
