package cardgame.blackjack.strategy;

import cardgame.Player;

public interface State {

    void handleState(DynamicStrategy context, Player player); // 状態遷移
    int decideBetChipsValue(Player player); 
    boolean isGettingHit(Player player); 
}
