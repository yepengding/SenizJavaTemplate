package org.veritasopher.senizjava.fsm;

import org.veritasopher.senizjava.fsm.base.ActionExecutor;

import static org.veritasopher.senizjava.fsm.core.Argument.*;
import static org.veritasopher.senizjava.fsm.core.Variable.*;

public class ActionEffect extends ActionExecutor {

    @Override
    public void a0() {
        System.out.println("a0");
        System.out.println(getVariable(STATUS, STATUS.getType()));
        System.out.println(getVariable(FLAG, FLAG.getType()));
        System.out.println(getArgument(ARG0, ARG0.getType()));
    }

    @Override
    public void a1() {
        System.out.println("a1");
        System.out.println(getVariable(STATUS, STATUS.getType()));
        System.out.println(getVariable(FLAG, FLAG.getType()));
        System.out.println(getArgument(ARG0, ARG0.getType()));
    }
}
