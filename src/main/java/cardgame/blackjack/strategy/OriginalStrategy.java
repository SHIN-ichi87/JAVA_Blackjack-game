package cardgame.blackjack.strategy;

import cardgame.Hand;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

public class OriginalStrategy implements Strategy, State {

	/**
	 * 手札の合計
	 */
	private int cardTotal;

	/**
	 * ディーラーの表カードの数値
	 */
	private int dealerFaceUpCard;

	/**
	 * ヒットまたはスタンド
	 */
	private boolean isHit;

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
		Hand playerHand = player.getTable().getHand(player.getSeatNumber());
		cardTotal = BlackJackRule.totalHand(playerHand);

		dealerFaceUpCard = BlackJackRule.getDealerFaceUpCard(
				player.getTable().getHand(0));

		if (BlackJackRule.isSoft(playerHand)) {// 手札のA(エース)を11と数える場合
			softTotals();
		} else { // 手札がその他の場合
			HardTotals();
		}

		return isHit;
	}

	/**
	 * A(エース)を11と数えるとき
	 */
	private void softTotals() {

		if (cardTotal >= 19)
			isHit = false;
		if (16 <= cardTotal && cardTotal <= 18) {
			if (dealerFaceUpCard >= 10 || dealerFaceUpCard == 1)
				isHit = true;
			else
				isHit = false;
		}
		if (13 <= cardTotal && cardTotal <= 15) {
			if (dealerFaceUpCard >= 6 || dealerFaceUpCard == 1)
				isHit = true;
			else
				isHit = false;
		}
		if (cardTotal == 12)
			isHit = true;
	}

	/**
	 * A(エース)を1と数えるとき
	 */
	private void HardTotals() {

		if (cardTotal >= 17)
			isHit = false;
		if (13 <= cardTotal && cardTotal <= 16) {
			if (dealerFaceUpCard >= 8 || dealerFaceUpCard == 1)
				isHit = true;
			else
				isHit = false;
		}
		if (11 <= cardTotal && cardTotal <= 12) {
			if (dealerFaceUpCard >= 5 || dealerFaceUpCard == 1)
				isHit = true;
			else
				isHit = false;
		}
		if (cardTotal <= 10)
			isHit = true;
	}

	public void handleState(DynamicStrategy context, Player player) {
		Hand hand = player.getTable().getHand(player.getSeatNumber());
		int cardTotal = BlackJackRule.totalHand(hand); // 手札の合計値を取得

		if (cardTotal >= 15) {
			context.setState(new BasicStrategy());
		}
	}
}
