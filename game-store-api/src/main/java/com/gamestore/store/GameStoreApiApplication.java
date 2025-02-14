package com.gamestore.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameStoreApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameStoreApiApplication.class, args);
		System.err.println(" 🎮 Game Store API Application Started Successfully ✅");
	}

}
