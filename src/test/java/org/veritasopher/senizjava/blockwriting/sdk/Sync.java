package org.veritasopher.senizjava.blockwriting.sdk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sync {

    public final static Lock lock = new ReentrantLock(true);

}
