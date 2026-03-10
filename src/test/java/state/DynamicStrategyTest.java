package state;

import cardgame.Banner;
import cardgame.blackjack.ExtendedBlackJackPlayer;
import cardgame.blackjack.strategy.State;
import cardgame.blackjack.strategy.DynamicStrategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DynamicStrategy の単体テスト
 */
public class DynamicStrategyTest {

	ExtendedBlackJackPlayer player;
	DynamicStrategy strategy;
	State expected; // 状態遷移先の期待値

	@Before
	public void setUp() {
		player = new ExtendedBlackJackPlayer();
		player.setStrategy(strategy = new DynamicStrategy());
	}

	@Test
	public void DynamicStrategyの初期化テスト() {
		// 初期化時に例外が発生しないことの確認
		assertNotNull(strategy);
	}

	@Test
	public void DynamicStrategyの実装確認テスト() {
		// ロジックの実行確認
		player.setJudgement(Banner.WIN);
		assertTrue(true);
	}
}