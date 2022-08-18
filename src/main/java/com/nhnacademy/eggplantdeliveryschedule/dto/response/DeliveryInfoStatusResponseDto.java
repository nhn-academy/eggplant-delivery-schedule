package com.nhnacademy.eggplantdeliveryschedule.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 바뀐 배송정보의 상태를 담고있는 Dto 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @since 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfoStatusResponseDto {

    @NotBlank(message = "주문 번호는 필수 사항 입니다.")
    private String orderNo;

    @NotNull(message = "배송 상태는 필수 사항 입니다.")
    private Status status;

    @NotBlank(message = "쇼핑몰 호스트 주소는 필수 사항 입니다.")
    private String shopHost;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime arrivalTime;

}
