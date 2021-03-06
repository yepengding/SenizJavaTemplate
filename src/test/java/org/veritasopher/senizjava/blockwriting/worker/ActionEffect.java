package org.veritasopher.senizjava.blockwriting.worker;

import org.veritasopher.senizjava.blockwriting.worker.base.ActionExecutor;

import static org.veritasopher.senizjava.blockwriting.worker.core.Argument.PID;
import static org.veritasopher.senizjava.blockwriting.worker.core.Variable.LOC;

public class ActionEffect extends ActionExecutor {

    @Override
    public void writeBlock() {
        String entryInfo = "Worker %s is writing block at location %s"
                .formatted(getArgument(PID, PID.getType()).orElseThrow(),
                        getVariable(LOC, LOC.getType()).orElseThrow());
        System.out.println(entryInfo);

        String exitInfo = "Worker %s finished writing.%n"
                .formatted(getArgument(PID, PID.getType()).orElseThrow());
        System.out.println(exitInfo);
    }

}
