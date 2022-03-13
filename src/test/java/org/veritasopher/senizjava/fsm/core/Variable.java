package org.veritasopher.senizjava.fsm.core;

import lombok.Getter;

@Getter
public enum Variable {
    STATUS("status", Integer.class),
    FLAG("flag", Boolean.class);

    private final String name;
    private final Class<?> type;

    Variable(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }

}
