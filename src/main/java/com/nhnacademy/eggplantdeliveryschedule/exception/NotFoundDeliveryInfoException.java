package com.nhnacademy.eggplantdeliveryschedule.exception;

/**
 * 배송정보 조회시 존재하지 않을때 예외처리하는 클래스입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
public class NotFoundDeliveryInfoException extends RuntimeException {

    private static final String MESSAGE = "해당 배송정보를 찾을 수 없습니다.";

    public NotFoundDeliveryInfoException() {
        super(MESSAGE);
    }

}
