package com.nhnacademy.eggplantdeliveryschedule.service.impl;

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
    public List<String> retrieveDeliveryInfoStatus() {
        return deliveryInfoRepository.retrieveStatusReady();
    }

}
