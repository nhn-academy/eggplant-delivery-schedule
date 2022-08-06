package com.nhnacademy.eggplantdeliveryschedule.dto;

import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@Setter
public class ChangedDeliveryInfoDto {

    private String trackingNo;
    private Status status;

}
