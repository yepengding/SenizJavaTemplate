package org.veritasopher.senizjava;

import org.junit.Test;


public class AppTest {

    @Test
    public void testFSM() {
        org.veritasopher.senizjava.fsm.SystemExecutor executor = new org.veritasopher.senizjava.fsm.SystemExecutor();
        executor.run();
    }

    @Test
    public void testSemaphore() {
        org.veritasopher.senizjava.semaphore.ControlSystemExecutor executor = new org.veritasopher.senizjava.semaphore.ControlSystemExecutor();
        executor.run();
    }

    @Test
    public void testBlockWriting() {
        org.veritasopher.senizjava.blockwriting.ControlSystemExecutor systemExecutor = new org.veritasopher.senizjava.blockwriting.ControlSystemExecutor();
        systemExecutor.run();
    }
}
