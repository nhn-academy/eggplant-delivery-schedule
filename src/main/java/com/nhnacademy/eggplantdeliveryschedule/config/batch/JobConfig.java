package com.nhnacademy.eggplantdeliveryschedule.config.batch;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Batch 에 부여된 Job 설정 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class JobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    public final StepConfig stepConfig;

    /**
     * 배송상태를 바꾸는 작업 입니다.
     *
     * @return 일괄 처리된 작업의 단위 입니다.
     */
    @Bean
    public Job deliveryStatusChangeJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(stepConfig.readyToDeliveringStep())
                                .build();
    }

    /**
     * 배송위치를 바꾸는 작업 입니다.
     *
     * @return 일괄 처리된 작업의 단위 입니다.
     */
    @Bean
    public Job deliveryLocationChangeJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(stepConfig.deliveryLocationChangeStep())
                                .build();
    }

    /**
     * 배송중인 상태를 도착상태로 바꾸는 작업 입니다.
     *
     * @return 일괄 처리된 작업의 단위 입니다.
     */
    @Bean
    public Job deliveringToArrivalJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(stepConfig.deliveringToArrivalStep())
                                .build();
    }

}
