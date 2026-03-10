package cardgame.blackjack.strategy;

import cardgame.Hand;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

public class DynamicStrategy implements Strategy {

    private State currentState;

    public DynamicStrategy() {
        //
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public int decideBetChipsValue(Player player) {
        handleState(player);
        return currentState.decideBetChipsValue(player);
    }

    public boolean isGettingHit(Player player) {
        handleState(player);
        return currentState.isGettingHit(player);
    }

    private void handleState(Player player) {
        Hand hand = player.getTable().getHand(player.getSeatNumber());
        int cardTotal = BlackJackRule.totalHand(hand); // 手札の合計値を取得
        if (cardTotal == 0) {
            setState(new SimpleStrategy());
            return;
        }

        currentState.handleState(this, player); // 状態を各戦略に委譲
    }
}
