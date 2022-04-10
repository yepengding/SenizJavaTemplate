package org.veritasopher.senizjava.fsm.core;

import lombok.Getter;

@Getter
public enum GlobalVariable {
    ;
    private final String name;
    private final Class<?> type;

    GlobalVariable(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }
}
