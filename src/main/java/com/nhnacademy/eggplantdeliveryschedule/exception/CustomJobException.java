package com.nhnacademy.eggplantdeliveryschedule.exception;

public class CustomJobException extends RuntimeException {

    private static final String MESSAGE = "Batch Job 처리 중 에러 발생.";

    public CustomJobException() {
        super(MESSAGE);
    }

}
