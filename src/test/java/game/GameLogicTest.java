package game;

import org.junit.Test;

/**
 * ゲーム開始から終了までの基本動作を確認するテスト。
 */

import cardgame.CardGame;
import cardgame.Dealer;
import cardgame.Deck;
import cardgame.Player;
import cardgame.Table;
import cardgame.blackjack.BlackJackDealer;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.gui.UITable;

public class GameLogicTest extends CardGame {

	/**
	 * GUIモード
	 */
	public static final String SWING = "Swing";
	public static final String AWT = "AWT";
	private static String GUI = AWT;

	/**
	 * 現在の GUI モードを返す。
	 * 
	 * @return GUIモード
	 */
	public static String getGUI() {
		return GUI;
	}

	/**
	 * GUI モードを設定する。
	 * 
	 * @param gui GUIモード
	 */
	public static void setGUI(String gui) {
		GUI = gui;
	}

	@Override
	protected Table createTable() {
		return new UITable();
	}

	@Override
	protected Deck createDeck() {
		return new Deck();
	}

	@Override
	protected Dealer createDealer() {
		return new BlackJackDealer();
	}

	@Override
	public Player createPlayer() {
		return new ExtendedBlackJackPlayer();
	}

	/**
	 * ゲームが最後まで進行することを確認する。
	 */
	@Test
	public void playGameRunsToCompletion() {

		CardGame cardGame;

		cardGame = new GameLogicTest();
		cardGame.setupGame();
		cardGame.playGame();
		System.exit(0);
	}

}
