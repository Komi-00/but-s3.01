package ui;

import java.util.Scanner;

import file.LoadScore;

public class SimpleGame {

	public static void main(String[] args) {
		InterfaceUI.clear();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre nom d'utilisateur : ");
		String username = sc.next();
		Player p = null;
		
		try {
			p = LoadScore.loadGame(username);
		} catch (Exception e) {
			p = new Player(username, 0);
			System.out.println("nouvelle Utilisateur : " + username);
		}
		
		SimpleInterfaceBAK game = new SimpleInterfaceBAK(p);
		System.out.println("Start ->");
		game.StartGame();
	}

}
