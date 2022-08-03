package com.nhnacademy.eggplantdeliveryschedule.dto.response;

import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@Setter
public class DeliveryInfoStatusResponseDto {

    private String trackingNo;

    private Status status;

}
