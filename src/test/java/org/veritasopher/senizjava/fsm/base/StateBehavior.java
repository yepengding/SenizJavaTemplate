package org.veritasopher.senizjava.fsm.base;

import org.veritasopher.senizjava.fsm.core.Argument;
import org.veritasopher.senizjava.fsm.core.State;
import org.veritasopher.senizjava.fsm.core.Variable;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public interface StateBehavior {

    void init(Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<?, Object> globalVariableSet);

    State next(ActionExecutor executor, Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<?, Object> globalVariableSet);

}
