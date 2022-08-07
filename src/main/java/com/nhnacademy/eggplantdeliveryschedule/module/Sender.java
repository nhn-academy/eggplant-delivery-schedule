package com.nhnacademy.eggplantdeliveryschedule.module;

import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 배송정보의 상태가 배송완료가 되면 메세지 Queue 에 정보를 넣기위한 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
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
