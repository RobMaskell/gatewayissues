package com.example.web;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class CustomWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        if (exchange.getRequest().getURI().getPath().equals("/")) {
            return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/index.html").build()).build());
        }

        return chain.filter(exchange);

//        ServerHttpRequest request = exchange.getRequest();
//
//        System.out.println("CUSTOM FILTER - " + request.getURI());
//
//        ServerHttpRequest.Builder builder = request.mutate();
////        if (exchange.getRequest().getURI().getPath().equals("/")) {
////            System.out.println("CUSTOM FILTER - mutate path /index.html");
////            builder.path("/index.html");
////        }
//
//
//        ServerHttpRequest newRequest = builder.build();
//
//        return chain.filter(exchange.mutate().request(newRequest).build());

    }
}
