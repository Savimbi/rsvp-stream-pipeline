package com.dorna.rsvpstream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class RsvpStreamApplication {

	private static final String MEETUP_RSVPS_ENDPOINT = "wss://streamer.cryptocompare.com/v2?api_key=a03506078610e5cd95c3b3a704e47ff29852e762c5241b9c884ea20e7b6dfe92";
	public static void main(String[] args) {
		SpringApplication.run(RsvpStreamApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeConnection(RsvpsWebSocketHandler rsvpsWebSocketHandler){
		return  args -> {
			WebSocketClient rsvpsSocketClient = new StandardWebSocketClient();
			rsvpsSocketClient.doHandshake(rsvpsWebSocketHandler,MEETUP_RSVPS_ENDPOINT);
		};
	}
}
