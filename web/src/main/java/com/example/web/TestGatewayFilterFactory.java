package com.example.web;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class TestGatewayFilterFactory implements GlobalFilter, Ordered {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestGatewayFilterFactory.class);

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders headers = exchange.getRequest().getHeaders();
        logger.info("===Before==================================");
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            for(String hdrval:header.getValue()) {
                logger.info(header.getKey() + " : " + hdrval);
            }
        }
        logger.info("===========================================");

        return chain.filter(exchange);

    }

}
