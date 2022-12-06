package tests;
import ui.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class PlayerTest {

	private static Player p1;
	private static Player p2;
	private static Player p3;
	private static Player p4;
	private static Player p5;
	
	public void setup() {
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		p4 = new Player("felix", 0);
		p5 = new Player();
	}
	
	@Test
	public void increaseTest() {
		setup();
		assertEquals(p1.getCurrentGame().getCowCoin(),0);
		p1.increaseCurrencyAmount(100, Currency.CowCoins);
		assertEquals(p1.getCurrentGame().getCowCoin(),100);
	}
	
	@Test
	public void decreaseTest() {
		setup();
		assertEquals(p2.getCurrentGame().getCowCoin(),0);
		p2.decreaseCurrencyAmount(100, Currency.CowCoins);
		assertEquals(p2.getCurrentGame().getCowCoin(),0);
		assertEquals(p3.getCurrentGame().getCowCoin(),0);
		p3.increaseCurrencyAmount(1000, Currency.CowCoins);
		assertEquals(p3.getCurrentGame().getCowCoin(),1000);
		p3.decreaseCurrencyAmount(100, Currency.CowCoins);
		assertEquals(p3.getCurrentGame().getCowCoin(),900);
	}
	
	@Test
	public void totalCoinsAmount() {
		setup();
		assertEquals(p4.getCurrentGame().getCowCoin(),0);
		p3.increaseCurrencyAmount(1000, Currency.CowCoins);
		assertEquals(p3.getCurrentGame().getCowCoin(),1000);
		assertEquals(p3.getTotalCowCoinsAmount(),1000);
		p3.decreaseCurrencyAmount(100, Currency.CowCoins);
		assertEquals(p3.getTotalCowCoinsAmount(),1000);
		assertEquals(p3.getCurrentGame().getCowCoin(),900);
	}
	
	@Test
	public void usernameTest() {
		setup();
		assertEquals(p4.getUsername(),"felix");
		assertEquals(p5.getUsername(),"default-user");
	}
}
