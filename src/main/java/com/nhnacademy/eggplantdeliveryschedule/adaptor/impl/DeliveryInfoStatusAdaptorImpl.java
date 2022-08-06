package com.nhnacademy.eggplantdeliveryschedule.adaptor.impl;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@ConfigurationProperties("eggplant-delivery-server")
public class DeliveryInfoStatusAdaptorImpl implements DeliveryInfoStatusAdaptor {

}
