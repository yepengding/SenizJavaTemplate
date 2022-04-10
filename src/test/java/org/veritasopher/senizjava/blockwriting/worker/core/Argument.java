package org.veritasopher.senizjava.blockwriting.worker.core;

import lombok.Getter;

@Getter
public enum Argument {
    ID("id", String.class);

    private final String name;
    private final Class<?> type;

    Argument(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }
}
