package com.geekbang.exception.myexceptions;

public class MyRuntimeExcpetion extends RuntimeException{
    public MyRuntimeExcpetion() {
    }

    public MyRuntimeExcpetion(String message) {
        super(message);
    }

    public MyRuntimeExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRuntimeExcpetion(Throwable cause) {
        super(cause);
    }
}
