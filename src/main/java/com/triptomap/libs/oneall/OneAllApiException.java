package com.triptomap.libs.oneall;

/**
 * @author smecsia
 */
public class OneAllApiException extends RuntimeException {
    public OneAllApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public OneAllApiException(String message) {
        super(message);
    }
}
