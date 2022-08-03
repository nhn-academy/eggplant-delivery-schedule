package com.nhnacademy.eggplantdeliveryschedule.entity;

import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * @author : 조재철
 * @since 1.0
 */
@Entity
public class DeliveryInfoStatusChange {

    @Id
    private String trackingNo;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDateTime completionTime;

}
