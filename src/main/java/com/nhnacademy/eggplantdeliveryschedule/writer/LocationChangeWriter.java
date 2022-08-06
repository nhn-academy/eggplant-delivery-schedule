package com.nhnacademy.eggplantdeliveryschedule.writer;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
public class LocationChangeWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) {
        // TODO : 새로운 위치 (2번) 이 위치에 추가 되게
    }
}
