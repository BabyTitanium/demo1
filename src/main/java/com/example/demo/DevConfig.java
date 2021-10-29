package com.example.demo;

import org.springframework.context.annotation.*;


@PropertySources({
        @PropertySource(value = "classpath:others.properties"),

        @PropertySource(value = "classpath:/hs-fund-srv-client-properties/hs-fund-srv-client-env.properties"),

})
@Configuration
public class DevConfig {
}
