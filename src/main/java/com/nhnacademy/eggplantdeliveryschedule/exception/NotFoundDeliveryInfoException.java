package com.nhnacademy.eggplantdeliveryschedule.exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class NotFoundDeliveryInfoException extends RuntimeException {

    private static final String MESSAGE = "해당 배송정보를 찾을 수 없습니다.";

    public NotFoundDeliveryInfoException() {
        super(MESSAGE);
    }

}
