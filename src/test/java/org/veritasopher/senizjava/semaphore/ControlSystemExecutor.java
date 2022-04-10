package org.veritasopher.senizjava.semaphore;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.program.core.Argument;
import org.veritasopher.senizjava.semaphore.sdk.SystemExecutorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.veritasopher.senizjava.semaphore.core.GlobalVariable.S;
import static org.veritasopher.senizjava.semaphore.program.core.Argument.ID;

public class ControlSystemExecutor {

    private final ConcurrentMap<GlobalVariable, Object> globalVariableSet;

    public ControlSystemExecutor() {
        this.globalVariableSet = new ConcurrentHashMap<>();
        initGlobalVariable();
    }

    private void initGlobalVariable() {
        globalVariableSet.put(S, 1);
    }

    public void run() {
        ConcurrentMap<Argument, Object> p1ArgSet = new ConcurrentHashMap<>();
        p1ArgSet.put(ID, "p1");
        org.veritasopher.senizjava.semaphore.program.SystemExecutor p1 = new org.veritasopher.senizjava.semaphore.program.SystemExecutor("p1", p1ArgSet, globalVariableSet);

        ConcurrentMap<Argument, Object> p2ArgSet = new ConcurrentHashMap<>();
        p1ArgSet.put(ID, "p2");
        org.veritasopher.senizjava.semaphore.program.SystemExecutor p2 = new org.veritasopher.senizjava.semaphore.program.SystemExecutor("p2", p2ArgSet, globalVariableSet);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<SystemExecutorThread<GlobalVariable>> callables = new ArrayList<>();
        callables.add(p1);
        callables.add(p2);
        try {
            executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
