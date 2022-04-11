package org.veritasopher.senizjava.semaphore.program;

import org.veritasopher.senizjava.semaphore.program.base.ActionExecutor;

import static org.veritasopher.senizjava.semaphore.program.core.Argument.PID;

public class ActionEffect extends ActionExecutor {

    @Override
    public void enterCritical() {
        String id = (String) getArgument(PID, PID.getType()).orElseThrow();
        System.out.println(id + " enters critical");
        System.out.println(id + " does critical");

    }

    @Override
    public void exitCritical() {
        String id = (String) getArgument(PID, PID.getType()).orElseThrow();
        System.out.println(id + " exits critical");
    }
}
