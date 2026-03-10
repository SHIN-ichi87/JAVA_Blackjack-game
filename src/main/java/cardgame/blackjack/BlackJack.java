package cardgame.blackjack;

import cardgame.CardGame;
import cardgame.Dealer;
import cardgame.Deck;
import cardgame.Player;
import cardgame.Table;
import cardgame.blackjack.gui.UITable;

/**
 * ブラックジャック
 *
 */
public class BlackJack extends CardGame {

	/**
	 * GUIモード
	 */
	public static final String SWING = "Swing";
	public static final String AWT = "AWT";
	private static String GUI = AWT;

	/**
	 * getter
	 *
	 * @return GUIモード
	 */
	public static String getGUI() {
		return GUI;
	}

	/**
	 * setter
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
	 * ブラックジャックゲームを実行する
	 *
	 * @param args 実行時パラメーター
	 */
	public static void main(String[] args) {

		CardGame cardGame;

		if (args.length >= 1) {
			/* 実行時パラメータの１番目はGUIのモード指定 */
			GUI = args[0];
		}

		if (args.length > 1 || (!GUI.equals(SWING) && !GUI.equals(AWT))) {
			System.err.println("起動方法 : java -jar blackjack.jar [" + SWING
					+ "|" + AWT + "]");
			System.exit(1);
		}

		cardGame = new BlackJack();
		cardGame.setupGame();
		cardGame.playGame();
		System.exit(0);
	}

}
