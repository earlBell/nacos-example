package com.nacos.demo;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

@Configuration
@Slf4j
public class  ConfigListener  implements ApplicationRunner {


    @Autowired
    private NacosConfig nacosConfig;

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigProperties.configServiceInstance().addListener(
                nacosConfig.getDataId(),  nacosConfig.getGroup(), new Listener() {

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        System.out.println(nacosConfig.getDataId()+"======================config changed: " + configInfo);
                    }

                    @Override
                    public Executor getExecutor() {
                        return null;
                    }
                });
    }


}
