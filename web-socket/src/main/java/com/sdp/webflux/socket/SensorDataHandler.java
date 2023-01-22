package com.sdp.webflux.socket;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SensorDataHandler implements WebSocketHandler {

    private final Flux<String> sensorData;

    public SensorDataHandler() {
        this.sensorData = Flux.interval(Duration.ofSeconds(1))
            .map(s -> s.toString())
            .share();
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
    	return session.send(sensorData.map(session::textMessage));
    }
}