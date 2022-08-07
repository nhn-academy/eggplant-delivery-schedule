package com.nhnacademy.eggplantdeliveryschedule.adaptor.impl;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 배송정보 상태를 전송하기 위한 Adaptor 구현체 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Component
@ConfigurationProperties("eggplant-delivery-server")
public class DeliveryInfoStatusAdaptorImpl implements DeliveryInfoStatusAdaptor {

}
