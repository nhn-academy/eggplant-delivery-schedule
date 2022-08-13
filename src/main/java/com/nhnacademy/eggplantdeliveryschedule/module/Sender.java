package com.nhnacademy.eggplantdeliveryschedule.module;

import static com.nhnacademy.eggplantdeliveryschedule.constant.ExchangeConstant.DIRECT_EXCHANGE;
import static com.nhnacademy.eggplantdeliveryschedule.constant.RoutingKeyConstant.ROUTING_CHANGE_DELIVERY_STATUS;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
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

    private final RabbitTemplate rabbitTemplate;

    public void sendChangeDeliveryStatus(final DeliveryInfoStatusResponseDto deliveryInfoStatusResponseDto) {
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE.getValue(), ROUTING_CHANGE_DELIVERY_STATUS.getValue(),
            deliveryInfoStatusResponseDto);
    }

}
