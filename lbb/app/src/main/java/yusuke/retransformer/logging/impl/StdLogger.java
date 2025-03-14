package yusuke.retransformer.logging.impl;

import yusuke.retransformer.logging.ILogger;

/**
 * A simple logger implementation that logs messages to the standard output
 */
public class StdLogger implements ILogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
