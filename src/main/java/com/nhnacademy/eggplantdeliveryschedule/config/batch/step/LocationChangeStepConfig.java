package com.nhnacademy.eggplantdeliveryschedule.config.batch.step;

import com.nhnacademy.eggplantdeliveryschedule.reader.LocationChangeReader;
import com.nhnacademy.eggplantdeliveryschedule.writer.LocationChangeWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class LocationChangeStepConfig {

    private static final int CHUNK_SIZE = 10;

    private final LocationChangeReader locationChangeReader;
    private final LocationChangeWriter locationChangeWriter;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public Step locationChangeList() {
        return stepBuilderFactory.get("배송 위치가 변경된 step")
                                 .allowStartIfComplete(true)
                                 .<String, String>chunk(CHUNK_SIZE)
                                 .reader(locationChangeReader)
                                 .writer(locationChangeWriter)
                                 .build();
    }
}
