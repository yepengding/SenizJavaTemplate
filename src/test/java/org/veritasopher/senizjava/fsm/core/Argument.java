package org.veritasopher.senizjava.fsm.core;

import lombok.Getter;

@Getter
public enum Argument {

    ARG0("arg0", Integer.class, 1);

    private final String name;
    private final Class<?> type;
    private final Object value;

    Argument(final String name, final Class<?> type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

}
