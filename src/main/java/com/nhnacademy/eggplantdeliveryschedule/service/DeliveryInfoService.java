package com.nhnacademy.eggplantdeliveryschedule.service;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import java.util.List;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface DeliveryInfoService {

    DeliveryInfoStatusResponseDto retrieveDeliveryInfoStatus();
}
