package com.liviamitrica.data.remote.exception;

public class ConnectivityException extends RuntimeException{

    public ConnectivityException(String message) {
        super("Server was not reached: " + message);
    }
}
