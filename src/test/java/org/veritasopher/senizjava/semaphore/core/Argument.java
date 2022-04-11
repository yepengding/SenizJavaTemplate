package org.veritasopher.senizjava.semaphore.core;

import lombok.Getter;

@Getter
public enum Argument {
    PID("pid", String.class);

    private final String name;
    private final Class<?> type;

    Argument(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }
}