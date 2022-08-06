package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : 조재철
 * @since 1.0
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
