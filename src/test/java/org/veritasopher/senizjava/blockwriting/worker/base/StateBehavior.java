package org.veritasopher.senizjava.blockwriting.worker.base;

import org.veritasopher.senizjava.blockwriting.core.GlobalVariable;
import org.veritasopher.senizjava.blockwriting.worker.core.Argument;
import org.veritasopher.senizjava.blockwriting.worker.core.State;
import org.veritasopher.senizjava.blockwriting.worker.core.Variable;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public interface StateBehavior {
    void init(Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<GlobalVariable, Object> globalVariableSet);

    State next(ActionExecutor executor, Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<GlobalVariable, Object> globalVariableSet);

}
