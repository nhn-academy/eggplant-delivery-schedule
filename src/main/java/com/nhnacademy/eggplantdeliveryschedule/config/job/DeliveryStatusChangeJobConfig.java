package com.nhnacademy.eggplantdeliveryschedule.config.job;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class DeliveryStatusChangeJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    public final DeliveryStatusChangeStepConfig deliveryStatusChangeStepConfig;

    @Bean
    public Job deliveryStatusChangeJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(deliveryStatusChangeStepConfig.prepareDeliveryStatusList())
                                .build();
    }

}
