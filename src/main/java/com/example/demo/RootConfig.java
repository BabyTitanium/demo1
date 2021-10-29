package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ImportResource({
//        "classpath:/hs-fund-srv-client-config/dubbo-config.xml",
//        "classpath:/hs-fund-srv-client-config/dubbo-consumer-client.xml"
//})
@ImportResource({
        "classpath*:/hs-fund-srv-client-config/context-client.xml",
})
@Import({DevConfig.class})
public class RootConfig {
}
