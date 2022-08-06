package com.nhnacademy.eggplantdeliveryschedule.exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class NotFoundDeliveryInfoException extends RuntimeException {

    public NotFoundDeliveryInfoException(String message) {
        super(message);
    }
}
