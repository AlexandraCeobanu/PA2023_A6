package com.example.clientApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

		/*createPlayer("Jucator1");
		createPlayer("Jucator2");
		createPlayer("Jucator3");
		createPlayer("Jucator4");
		createPlayer("Jucator5");
		*/
		getAllPlayers();

		// Get player by ID
		//getPlayerById(1);

		// Update player
		updatePlayer(1,"Updated player");

		// Delete player
		deletePlayer(5);
		getAllPlayers();
	}


	private static void createPlayer(String name) {
		String url = "http://localhost:8081/players?name=" + name;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST,null, Integer.class);

		if (response.getStatusCode()== HttpStatus.OK) {
			System.out.println("Player created successfully.");
		} else {
			System.out.println("Failed to create player.");
		}
	}

	private static void getAllPlayers() {
		String url = "http://localhost:8081/players/all";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Player>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>() {}
		);

		if (response.getStatusCode()==HttpStatus.OK) {
			List<Player> players = response.getBody();
			if (players != null) {
				for (Player player : players) {
					System.out.println("Player: " + player);
				}
			}
		} else {
			System.out.println("Failed to get players.");
		}
	}

	private static void getPlayerById(int id) {
		String url = "http://localhost:8081/players/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Player> response = restTemplate.getForEntity(url, Player.class);

		if (response.getStatusCode()==HttpStatus.OK) {
			Player player = response.getBody();
			if (player != null) {
				System.out.println("Player: " + player);
			} else {
				System.out.println("Player not found.");
			}
		} else {
			System.out.println("Failed to get player.");
		}
	}

	private static void updatePlayer(int id,String name) {
		String url = "http://localhost:8081/players/" + id+ "?name=" +name;
		Player updatedPlayer = new Player(id, "Updated Player");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
		if (response.getStatusCode()==HttpStatus.OK) {
			String responseS = response.getBody();
			System.out.println(responseS);
		} else {
			System.out.println("Failed to get player.");
		}
	}
	private static void deletePlayer(int id) {
		String url = "http://localhost:8081/players/delete?id=" +id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Player deleted successfully.");
		} else {
			System.out.println("Failed to delete player.");
		}
	}
}
