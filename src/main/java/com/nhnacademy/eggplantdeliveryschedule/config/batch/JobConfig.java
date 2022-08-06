package com.nhnacademy.eggplantdeliveryschedule.config.batch;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class JobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    public final StepConfig stepConfig;

    @Bean
    public Job locationChangeJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(stepConfig.locationChangeList())
                                .build();
    }

    @Bean
    public Job deliveryStatusChangeJob() {
        // Job 아이디의 중복을 막기위해 UUID 를 사용.
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(stepConfig.readyToDeliveringStep())
                                .build();
    }

}
