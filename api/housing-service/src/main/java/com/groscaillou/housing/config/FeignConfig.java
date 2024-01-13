package com.groscaillou.housing.config;

import com.groscaillou.housing.client.FeignResultDecoder;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Decoder feignDecoder() {
        return new FeignResultDecoder();
    }
}
