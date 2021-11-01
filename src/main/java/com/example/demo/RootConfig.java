package com.example.demo;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource({
        "classpath*:fund-context-client.xml",
})
public class RootConfig {
}
