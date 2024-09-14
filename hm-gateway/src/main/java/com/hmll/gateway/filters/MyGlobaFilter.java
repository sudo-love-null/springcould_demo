package com.hmll.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobaFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        System.out.println("globadFilter pro 阶段执行");
        return chain.filter(exchange);
    }

    /**
     * 过滤器的优先级，要比最后实现转发的过滤器的优先级高，不过最后实现转发的优先级是最低的
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
