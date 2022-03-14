package org.veritasopher.senizjava.semaphore.core;

import lombok.Getter;

@Getter
public enum GlobalVariable {
    S("s", Integer.class);
    private final String name;
    private final Class<?> type;

    GlobalVariable(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }
}
