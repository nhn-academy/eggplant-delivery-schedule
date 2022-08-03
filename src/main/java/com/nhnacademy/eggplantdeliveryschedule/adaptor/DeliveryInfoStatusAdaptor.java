package com.nhnacademy.eggplantdeliveryschedule.adaptor;

import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import java.util.List;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface DeliveryInfoStatusAdaptor {

    List<DeliveryInfoStatusResponseDto> findDeliveryInfoStatuses();

    void insertChangedDeliveryInfo(List<ChangedDeliveryInfoDto> changedDeliveryInfoDto);
}
