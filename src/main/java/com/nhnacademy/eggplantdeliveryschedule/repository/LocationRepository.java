package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository 를 상속받아 Location 테이블 데이터 접근을 위한 Repository 입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
