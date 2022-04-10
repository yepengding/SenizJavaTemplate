package org.veritasopher.senizjava.blockwriting.worker.core;

import lombok.Getter;

@Getter
public enum Variable {
    LOC("loc", Integer.class);
    private final String name;
    private final Class<?> type;

    Variable(final String name, final Class<?> type) {
        this.name = name;
        this.type = type;
    }
}
