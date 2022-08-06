package com.nhnacademy.eggplantdeliveryschedule.config.batch.job;

import com.nhnacademy.eggplantdeliveryschedule.config.batch.step.DeliveryStatusChangeStepConfig;
import com.nhnacademy.eggplantdeliveryschedule.config.batch.step.LocationChangeStepConfig;
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
public class LocationChangeJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    public final LocationChangeStepConfig locationChangeStepConfig;

    @Bean
    public Job locationChangeJob() {
        return jobBuilderFactory.get(UUID.randomUUID().toString())
                                .start(locationChangeStepConfig.locationChangeList())
                                .build();
    }
}
