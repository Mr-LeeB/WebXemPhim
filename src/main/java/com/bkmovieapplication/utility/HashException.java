package com.bkmovieapplication.utility;

import java.io.Serial;

public class HashException extends RuntimeException {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public HashException(String message, Throwable cause) {
        super(message, cause);
    }
}
