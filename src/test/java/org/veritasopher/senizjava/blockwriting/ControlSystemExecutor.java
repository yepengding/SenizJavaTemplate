package org.veritasopher.senizjava.blockwriting;

import org.veritasopher.senizjava.blockwriting.core.GlobalVariable;
import org.veritasopher.senizjava.blockwriting.worker.core.Argument;
import org.veritasopher.senizjava.blockwriting.sdk.SystemExecutorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.veritasopher.senizjava.blockwriting.core.GlobalVariable.S;
import static org.veritasopher.senizjava.blockwriting.worker.core.Argument.ID;

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
        ConcurrentMap<Argument, Object> w1ArgSet = new ConcurrentHashMap<>();
        w1ArgSet.put(ID, "w1");
        org.veritasopher.senizjava.blockwriting.worker.SystemExecutor w1 = new org.veritasopher.senizjava.blockwriting.worker.SystemExecutor("w1", w1ArgSet, globalVariableSet);

        ConcurrentMap<Argument, Object> w2ArgSet = new ConcurrentHashMap<>();
        w2ArgSet.put(ID, "w2");
        org.veritasopher
                .senizjava.blockwriting.worker.SystemExecutor w2 = new org.veritasopher.senizjava.blockwriting.worker.SystemExecutor("w2", w2ArgSet, globalVariableSet);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

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
