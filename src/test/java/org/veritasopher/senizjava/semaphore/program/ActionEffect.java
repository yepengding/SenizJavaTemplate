package org.veritasopher.senizjava.semaphore.program;

import org.veritasopher.senizjava.semaphore.program.base.ActionExecutor;

public class ActionEffect extends ActionExecutor {

    @Override
    public void enterCritical() {
        System.out.println("Entering critical");
    }

    @Override
    public void exitCritical() {
        System.out.println("Exiting critical");
    }
}
