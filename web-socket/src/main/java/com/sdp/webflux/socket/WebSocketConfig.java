package com.sdp.webflux.socket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

@Configuration
public class WebSocketConfig {

	@Bean
	HandlerMapping webSocketHandlerMapping(SensorDataHandler handler) {
	    Map<String, WebSocketHandler> map = new HashMap<>();
	    map.put("/sensors", handler);

	    SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
	    handlerMapping.setOrder(1);
	    handlerMapping.setUrlMap(map);
	    return handlerMapping;
	}
}
