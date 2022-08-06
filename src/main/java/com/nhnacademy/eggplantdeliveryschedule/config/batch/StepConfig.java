package com.nhnacademy.eggplantdeliveryschedule.config.batch;

import com.nhnacademy.eggplantdeliveryschedule.reader.DeliveryLocationChangeReader;
import com.nhnacademy.eggplantdeliveryschedule.reader.LocationChangeReader;
import com.nhnacademy.eggplantdeliveryschedule.reader.ReadyToDeliveringReader;
import com.nhnacademy.eggplantdeliveryschedule.writer.DeliveryLocationChangeWriter;
import com.nhnacademy.eggplantdeliveryschedule.writer.LocationChangeWriter;
import com.nhnacademy.eggplantdeliveryschedule.writer.ReadyToDeliveringWriter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private static final int CHUNK_SIZE = 10;
    private final LocationChangeReader locationChangeReader;
    private final LocationChangeWriter locationChangeWriter;
    private final ReadyToDeliveringReader readyToDeliveringReader;
    private final ReadyToDeliveringWriter readyToDeliveringWriter;
    private final DeliveryLocationChangeReader deliveryLocationChangeReader;
    private final DeliveryLocationChangeWriter deliveryLocationChangeWriter;
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

    @Bean
    @JobScope
    public Step readyToDeliveringStep() {
        return stepBuilderFactory.get("배송 상태를 얻는 step")
                                 .allowStartIfComplete(true)
                                 .<List<String>, List<String>>chunk(CHUNK_SIZE)
                                 .reader(readyToDeliveringReader)
                                 .writer(readyToDeliveringWriter)
                                 .build();
    }

    @Bean
    @JobScope
    public Step deliveryLocationChangeStep() {
        return stepBuilderFactory.get("배송 위치 상태를 바꿔주는 step")
                                 .allowStartIfComplete(true)
                                 .<List<String>, List<String>>chunk(CHUNK_SIZE)
                                 .reader(deliveryLocationChangeReader)
                                 .writer(deliveryLocationChangeWriter)
                                 .build();
    }

}
