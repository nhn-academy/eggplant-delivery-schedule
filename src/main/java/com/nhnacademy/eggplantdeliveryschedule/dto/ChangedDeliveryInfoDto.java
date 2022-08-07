package com.nhnacademy.eggplantdeliveryschedule.dto;

import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * 바뀐 배송정보의 상태를 담고있는 Dto 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @since 1.0
 */
@Getter
@Setter
public class ChangedDeliveryInfoDto {

    private String trackingNo;
    private Status status;

}
