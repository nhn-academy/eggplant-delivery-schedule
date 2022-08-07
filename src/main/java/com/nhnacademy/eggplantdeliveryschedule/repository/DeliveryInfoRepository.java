package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * QueryDsl 의 사용을 위한 CustomRepository 를 상속받고,
 * JpaRepository 를 상속받아 Db 에 접근하는 인터페이스 입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, String>, CustomDeliveryInfoRepository {

}
