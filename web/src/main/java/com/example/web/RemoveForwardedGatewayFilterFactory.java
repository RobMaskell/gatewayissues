package com.example.web;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

//@Component
public class RemoveForwardedGatewayFilterFactory implements GlobalFilter, Ordered {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RemoveForwardedGatewayFilterFactory.class);

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("Run Remove Forwarded Global filter");

//        exchange.getRequest().getHeaders().remove("Forwarded");
//        exchange.getRequest().getHeaders().remove("forwarded");
//
//        return chain.filter(exchange);

//        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .headers(httpHeaders -> httpHeaders.remove("forwarded"))
                    .headers(httpHeaders -> httpHeaders.remove("Forwarded"))
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
//        };

    }

}
