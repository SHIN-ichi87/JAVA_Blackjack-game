package cardgame;

import java.util.ArrayList;
import java.util.List;

import cardgame.observer.CardDeckObserver;
import cardgame.observer.CardDeckSubject;

/**
 * ディーラー
 *
 *
 *
 */
public abstract class Dealer implements CardDeckSubject {

	/**
	 * 名前
	 */
	protected String name = "ディーラー";

	/**
	 * getter
	 *
	 * @return Dealerの名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 選択(ヒット : 真、スタンド : 偽)
	 */
	protected boolean choice;

	/**
	 * getter
	 *
	 * @return choice(ヒット : 真、スタンド : 偽)
	 */
	public boolean getChoice() {
		return choice;
	}

	/**
	 * テーブル
	 */
	protected Table table;

	/**
	 * カードデッキ
	 */
	protected Deck deck;

	/**
	 * プレイヤー
	 */
	protected List<Player> players;

	/**
	 * カードデッキをシャッフルしたことを通知するための観察者
	 */
	private List<CardDeckObserver> observers = new ArrayList<CardDeckObserver>();

	/**
	 * Dealerのコンストラクタ
	 */
	public Dealer() {
	}

	/**
	 * ゲームを進行する
	 */
	public final void setupDealer() {
		table = CardGame.getTable();
		deck = CardGame.getDeck();
		players = CardGame.getPlayers();
	}

	/**
	 * ゲームを進行する
	 */
	public abstract void playGame();

	/**
	 * カードデッキの観察者を追加する
	 *
	 * @param observer CardDeckのオブザーバー
	 */
	public void registerCardDeckObserver(CardDeckObserver observer) {
		observers.add(observer);
	}

	/**
	 * カードデッキの観察者にCardDeckがシャフルされたことを通知する
	 */
	public void notifyCardDeckObservers() {
		for (CardDeckObserver observer : observers) {
			observer.lookAtCardDeck();
		}
	}

}