package cardgame.observer;

/**
 * 手札の観察者
 * 
 * 
 */
public interface HandObserver {

	/**
	 * 手札を観察する
	 * 
	 * @param seatNumber
	 *            座席番号
	 */
	public abstract void lookAtHand(int seatNumber);
}
