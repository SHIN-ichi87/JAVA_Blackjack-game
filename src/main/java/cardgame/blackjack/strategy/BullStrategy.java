package cardgame.blackjack.strategy;

import cardgame.Hand;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

/**
 * 強気な戦略
 * 
 * 
 */
public class BullStrategy implements Strategy, State {

	public BullStrategy() {
	}

	@Override
	public int decideBetChipsValue(Player player) {
		int chipsValue = player.getChipsValue();
		int betChips = chipsValue / 4;

		if (betChips == 0 && chipsValue > 0) {
			betChips = chipsValue;
		}

		return betChips;
	}

	@Override
	public boolean isGettingHit(Player player) {
		boolean isHit = false;
		Hand hand = player.getTable().getHand(player.getSeatNumber());

		if (BlackJackRule.totalHand(hand) < 18) {
			isHit = true;
		}

		return isHit;
	}

	public void handleState(DynamicStrategy context, Player player) {
		// do nothing
	}

}
