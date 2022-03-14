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
        org.veritasopher.senizjava.semaphore.SystemExecutor executor = new org.veritasopher.senizjava.semaphore.SystemExecutor();
        executor.run();
    }
}
