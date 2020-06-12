package com.yxy.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerFactoryCustomizerConfig implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Value("${server.http1.1.port}")
    private int httpPort;

    /**
     * 自定义HTTP端口号
     *
     * @param factory
     */
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addBuilderCustomizers((UndertowBuilderCustomizer) builder -> {
            builder.addHttpListener(httpPort, "0.0.0.0");
        });
    }
}
