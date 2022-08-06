package com.nhnacademy.eggplantdeliveryschedule.module;

import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@RequiredArgsConstructor
@Component
public class Sender {

    private static final String DELIVERY_EXCHANGE = "exchange.direct";
    public static final String ROUTING_DELIVERY_ARRIVAL = "routing.DeliveryArrival";

    private final RabbitTemplate rabbitTemplate;

    public void sendDeliveryArrival(final ChangedDeliveryInfoDto changedDeliveryInfoDto) {
        rabbitTemplate.convertAndSend(DELIVERY_EXCHANGE, ROUTING_DELIVERY_ARRIVAL, changedDeliveryInfoDto);
    }

}
