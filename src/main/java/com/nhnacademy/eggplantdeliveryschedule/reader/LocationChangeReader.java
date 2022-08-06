package com.nhnacademy.eggplantdeliveryschedule.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
public class LocationChangeReader implements ItemReader<String> {

    @Override
    public String read() {
        return null; // TODO : 위치 1까지 온 놈들 운송장번호 뽑아내는 쿼리 만들어야함
    }
}
