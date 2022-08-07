package com.nhnacademy.eggplantdeliveryschedule;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 스케쥴링과 배치 프로세싱을 사용할 수 있는 스프링 부트 어플리케이션 클래스입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class EggplantDeliveryScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggplantDeliveryScheduleApplication.class, args);
    }

}
