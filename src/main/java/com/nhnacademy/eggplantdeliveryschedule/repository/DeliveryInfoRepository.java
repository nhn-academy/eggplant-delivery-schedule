package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, String>, CustomDeliveryInfoRepository {

}
