package org.veritasopher.senizjava.blockwriting;

import org.veritasopher.senizjava.blockwriting.core.GlobalVariable;
import org.veritasopher.senizjava.blockwriting.sdk.SystemExecutorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.veritasopher.senizjava.blockwriting.core.GlobalVariable.S;

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
        ConcurrentMap<org.veritasopher.senizjava.blockwriting.worker.core.Argument, Object> argSet;
        argSet = new ConcurrentHashMap<>();
        argSet.put(org.veritasopher.senizjava.blockwriting.worker.core.Argument.PID, "w1");
        org.veritasopher.senizjava.blockwriting.worker.SystemExecutor w1 = new org.veritasopher.senizjava.blockwriting.worker.SystemExecutor("w1", argSet, gVarSet);

        argSet = new ConcurrentHashMap<>();
        argSet.put(org.veritasopher.senizjava.blockwriting.worker.core.Argument.PID, "w2");
        org.veritasopher
                .senizjava.blockwriting.worker.SystemExecutor w2 = new org.veritasopher.senizjava.blockwriting.worker.SystemExecutor("w2", argSet, gVarSet);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<SystemExecutorThread<GlobalVariable>> callables = new ArrayList<>();
        callables.add(w1);
        callables.add(w2);
        try {
            executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
