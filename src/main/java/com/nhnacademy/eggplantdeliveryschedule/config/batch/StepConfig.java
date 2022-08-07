package com.nhnacademy.eggplantdeliveryschedule.config.batch;

import com.nhnacademy.eggplantdeliveryschedule.reader.DeliveringToArrivalReader;
import com.nhnacademy.eggplantdeliveryschedule.reader.DeliveryLocationChangeReader;
import com.nhnacademy.eggplantdeliveryschedule.reader.ReadyToDeliveringReader;
import com.nhnacademy.eggplantdeliveryschedule.writer.DeliveringToArrivalWriter;
import com.nhnacademy.eggplantdeliveryschedule.writer.DeliveryLocationChangeWriter;
import com.nhnacademy.eggplantdeliveryschedule.writer.ReadyToDeliveringWriter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Job 에 지정된 과정을 처리하는 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @since 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private static final int CHUNK_SIZE = 10;
    private final ReadyToDeliveringReader readyToDeliveringReader;
    private final ReadyToDeliveringWriter readyToDeliveringWriter;
    private final DeliveryLocationChangeReader deliveryLocationChangeReader;
    private final DeliveryLocationChangeWriter deliveryLocationChangeWriter;
    private final DeliveringToArrivalReader deliveringToArrivalReader;
    private final DeliveringToArrivalWriter deliveringToArrivalWriter;
    private final StepBuilderFactory stepBuilderFactory;

    /**
     * 배송 준비중인 상태를 배송중으로 바꿔주는 과정 입니다.
     *
     * @return 일괄 처리된 과정 입니다.
     */
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

    /**
     * 배송중인 상태를 배송완료로 바꿔주는 과정 입니다.
     *
     * @return 일괄 처리된 과정 입니다.
     */
    @Bean
    @JobScope
    public Step deliveringToArrivalStep() {
        return stepBuilderFactory.get("배송 중 -> 배송 완료 step")
                                 .allowStartIfComplete(true)
                                 .<List<String>, List<String>>chunk(CHUNK_SIZE)
                                 .reader(deliveringToArrivalReader)
                                 .writer(deliveringToArrivalWriter)
                                 .build();
    }

    /**
     * 배송위치를 바꿔주는 과정 입니다.
     *
     * @return 일괄 처리된 과정 입니다.
     */
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
