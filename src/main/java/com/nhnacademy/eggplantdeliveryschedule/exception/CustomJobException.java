package com.nhnacademy.eggplantdeliveryschedule.exception;

/**
 * 배치 서버의 Job 처리중 에러가 발생시 예외처리하는 클래스 입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
public class CustomJobException extends RuntimeException {

    private static final String MESSAGE = "Batch Job 처리 중 에러 발생.";

    public CustomJobException() {
        super(MESSAGE);
    }

}
