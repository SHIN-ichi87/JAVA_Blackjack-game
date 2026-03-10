package cardgame.blackjack.strategy;

import cardgame.Player;

/**
 * 人間の戦略(初期値を設定するのみ)
 * 
 * 
 */

public class HumanStrategy implements Strategy, State {

	@Override
	public int decideBetChipsValue(Player player) {
		return player.getBetChips();
	}

	@Override
	public boolean isGettingHit(Player player) {
		return true;
	}

	public void handleState(DynamicStrategy context, Player player) {
		// do nothing
	}

}
