package com.nacos.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Data
public class NacosConfig {

    /**
     * 配置中心dataId，规则是：spirng.application.name -  环境.文件格式
     */
    @Value("${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}")
    private String dataId;

    @Value("${spring.cloud.nacos.config.group}")
    private String group;


}
