package org.veritasopher.senizjava.semaphore;

import org.veritasopher.senizjava.semaphore.core.GlobalVariable;
import org.veritasopher.senizjava.semaphore.sdk.SystemExecutorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.veritasopher.senizjava.semaphore.core.GlobalVariable.S;

public class ControlSystemExecutor {

    private final ConcurrentMap<GlobalVariable, Object> gVarSet;

    public ControlSystemExecutor() {
        this.gVarSet = new ConcurrentHashMap<>();
        initGlobalVariable();
    }

    private void initGlobalVariable() {
        gVarSet.put(S, 1);
    }

    public void run() {
        ConcurrentMap<org.veritasopher.senizjava.semaphore.program.core.Argument, Object> p1ArgSet = new ConcurrentHashMap<>();
        p1ArgSet.put(org.veritasopher.senizjava.semaphore.program.core.Argument.PID, "p1");
        org.veritasopher.senizjava.semaphore.program.SystemExecutor p1 = new org.veritasopher.senizjava.semaphore.program.SystemExecutor("p1", p1ArgSet, gVarSet);

        ConcurrentMap<org.veritasopher.senizjava.semaphore.program.core.Argument, Object> p2ArgSet = new ConcurrentHashMap<>();
        p2ArgSet.put(org.veritasopher.senizjava.semaphore.program.core.Argument.PID, "p2");
        org.veritasopher.senizjava.semaphore.program.SystemExecutor p2 = new org.veritasopher.senizjava.semaphore.program.SystemExecutor("p2", p2ArgSet, gVarSet);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

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
