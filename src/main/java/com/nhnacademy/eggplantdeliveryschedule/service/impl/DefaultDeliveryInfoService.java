package com.nhnacademy.eggplantdeliveryschedule.service.impl;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.service.DeliveryInfoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class DefaultDeliveryInfoService implements DeliveryInfoService {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public DeliveryInfoStatusResponseDto retrieveDeliveryInfoStatus() {
        return null; // TODO 1 : deliveryInfoRepository 구현해서 해당 채워넣기 (query DSL로)
    }
}
