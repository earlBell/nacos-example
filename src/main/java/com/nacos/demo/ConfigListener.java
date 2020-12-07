package com.nacos.demo;

import com.purgeteam.dynamic.config.starter.event.ActionConfigEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class  ConfigListener  implements ApplicationListener<ActionConfigEvent> {

    @Override
    public void onApplicationEvent(ActionConfigEvent event) {
        log.info("config ------------- start");
        event.getPropertyMap().entrySet().forEach(entry->{
            log.info("Key : {}, Value : {} ",entry.getKey(),entry.getValue());
        });
        log.info("config ------------- end");
    }

}
