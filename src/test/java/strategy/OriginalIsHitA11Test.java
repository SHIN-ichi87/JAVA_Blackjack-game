package strategy;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cardgame.Card;
import cardgame.Card.RANK;
import cardgame.Card.SUIT;
import cardgame.CardGame;
import cardgame.Table;
import cardgame.blackjack.BlackJackPlayer;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.UITable;

/**
 * OriginalStrategy の単体テスト（網羅テスト）
 */
public class OriginalIsHitA11Test {

	static Table table;
	static BlackJackPlayer player;
	RANK[] ranks = Card.getRanks();		// カードランクの集合 ACE("A"),...,KING("K")
	boolean expected;	// Hit(true) or Stand(false) 期待値

	@BeforeClass					// TableとPlayerの準備として1回だけ実行する
	public static void setUp() {
		table = new UITable();
		CardGame.setTable(table);
		table.setupTable(); 	// Tableの準備
		player = new ExtendedBlackJackPlayer();
		player.setupPlayer(1);	// 座席番号1のPlayerの準備
	}
	/**
	 * A(エース)を11と数えるとき
	 */
	@Test
	public void  Aを11と数えた時のchoiceテスト01() {
		// テスト条件: cardTotal >= 19
		// Playerの手札: A, {8,...,10}; stand
		expected = false;
		for (int i = 7; i < 10; i++){
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);		
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
	}

	@Test
	public void  Aを11と数えた時のchoiceテスト02() {
		// テスト条件: 16 <= cardTotal <= 18 && dealerFaceUpCard >= 2 && dealerFaceUpCard <= 9
		// Playerの手札: A, {5,..,7}; Dealerの手札: 2,..,9: stand
		for (int i = 4; i < 7; i++){

			// Dealerの手札: 2,..,9: stand
			expected = false;
			for(int k = 1; k < 9; k++){
				table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
				table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
				table.putCard(new Card(ranks[k], SUIT.Spade), 0);	
				player.isGettingHit();
				assertThat(player.getChoice(),is(expected));
				table.clearObject();
			}

			// Dealerの手札: 10, A: hit
			expected = true;
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
			table.putCard(new Card(RANK.TEN, SUIT.Spade), 0);	
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();

			expected = true;
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
			table.putCard(new Card(RANK.ACE, SUIT.Spade), 0);	
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}
		
	}

	@Test
	public void  Aを11と数えた時のchoiceテスト03() {
		// テスト条件: 13 <= cardTotal <= 15 && dealerFaceUpCard >= 2 && dealerFaceUpCard <= 5
		// Playerの手札: A, {2,...,4} 
		for (int i = 1; i < 4; i++){

			// Dealerの手札: 2,..,5: stand
			expected = false;
			for(int k = 1; k < 5; k++){
				table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
				table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
				table.putCard(new Card(ranks[k], SUIT.Spade), 0);	
				player.isGettingHit();
				assertThat(player.getChoice(),is(expected));
				table.clearObject();
			}

			// Dealerの手札: 6,..,10: hit
			expected = true;
			for(int k = 5; k < 10; k++){
				table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
				table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
				table.putCard(new Card(ranks[k], SUIT.Spade), 0);	
				player.isGettingHit();
				assertThat(player.getChoice(),is(expected));
				table.clearObject();
			}

			//Dealerの手札: A: hit
			expected = true;
			table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
			table.putCard(new Card(ranks[i], SUIT.Diamond), 1);	
			table.putCard(new Card(RANK.ACE, SUIT.Spade), 0);	
			player.isGettingHit();
			assertThat(player.getChoice(),is(expected));
			table.clearObject();
		}

		
	}
	@Test
	public void  Aを11と数えた時のchoiceテスト04() {
		// Playerの手札: A, A
		expected = true;
		table.putCard(new Card(RANK.ACE, SUIT.Club), 1);
		table.putCard(new Card(RANK.ACE, SUIT.Diamond), 1);
		player.isGettingHit();
		assertThat(player.getChoice(), is(expected));
		table.clearObject();
	}
}
