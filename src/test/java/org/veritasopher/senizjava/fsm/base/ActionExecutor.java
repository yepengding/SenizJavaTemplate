package org.veritasopher.senizjava.fsm.base;

import lombok.Setter;
import org.veritasopher.senizjava.fsm.core.Action;
import org.veritasopher.senizjava.fsm.core.Argument;
import org.veritasopher.senizjava.fsm.core.Variable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public abstract class ActionExecutor implements Action {

    @Setter
    private ConcurrentMap<Argument, Object> argumentSet;

    @Setter
    private Map<Variable, Object> variableSet;

    protected <T> Optional<T> getArgument(Argument argument, Class<T> type) {
        Object val = this.argumentSet.get(argument);
        if (val != null) {
            return Optional.of(type.cast(val));
        }
        return Optional.empty();
    }

    protected <T> Optional<T> getVariable(Variable variable, Class<T> type) {
        Object val = this.variableSet.get(variable);
        if (val != null) {
            return Optional.of(type.cast(val));
        }
        return Optional.empty();
    }

}
