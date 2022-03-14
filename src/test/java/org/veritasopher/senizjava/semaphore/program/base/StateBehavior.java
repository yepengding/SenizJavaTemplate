package org.veritasopher.senizjava.semaphore.program.base;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.core.Argument;
import org.veritasopher.senizjava.semaphore.program.core.State;
import org.veritasopher.senizjava.semaphore.program.core.Variable;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public interface StateBehavior {
    void init(Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<GlobalVariable, Object> globalVariableSet);

    State next(ActionExecutor executor, Map<Variable, Object> variableSet, ConcurrentMap<Argument, Object> argumentSet, ConcurrentMap<GlobalVariable, Object> globalVariableSet);

}
