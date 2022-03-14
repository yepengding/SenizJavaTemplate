package org.veritasopher.senizjava.semaphore.program.core;

public interface Action {
    void enterCritical();

    void exitCritical();
}
