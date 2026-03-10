package cardgame.blackjack.strategy;

import cardgame.Hand;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

/**
 * ディーラーと同じ戦略
 * 
 * 
 */
public class SimpleStrategy implements Strategy, State {

	public SimpleStrategy() {
	}

	@Override
	public int decideBetChipsValue(Player player) {
		int chipsValue = player.getChipsValue();
		int betChips = chipsValue / 5;

		if (betChips <= 0) {
			betChips = chipsValue;
		}

		return betChips;
	}

	@Override
	public boolean isGettingHit(Player player) {
		boolean isHit = false;
		Hand hand = player.getTable().getHand(player.getSeatNumber());

		if (BlackJackRule.totalHand(hand) < 16) {
			isHit = true;
		}

		return isHit;
	}

	public void handleState(DynamicStrategy context, Player player) {
		Hand hand = player.getTable().getHand(player.getSeatNumber());
		int cardTotal = BlackJackRule.totalHand(hand); // 手札の合計値を取得

		if (cardTotal <= 14 && cardTotal >= 10) {
			context.setState(new OriginalStrategy());
		} else if (cardTotal >= 15) {
			context.setState(new BasicStrategy());
		}
	}

}