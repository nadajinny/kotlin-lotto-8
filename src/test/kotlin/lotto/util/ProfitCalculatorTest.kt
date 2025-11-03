package lotto.util

import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    private val calculator = ProfitCalculator()

    @Test
    @DisplayName("등수 리스트를 받아 각 Rank별 개수를 올바르게 계산한다")
    fun `rankCount는 각 등수 개수를 반환한다`() {
        // given
        val ranks = listOf(
            Rank.First,
            Rank.Fifth,
            Rank.Fifth,
            Rank.Second,
            Rank.None,
            Rank.Fifth
        )

        // when
        val result = calculator.rankCount(ranks)

        // then
        assertThat(result[Rank.First]).isEqualTo(1)
        assertThat(result[Rank.Second]).isEqualTo(1)
        assertThat(result[Rank.Fifth]).isEqualTo(3)
        assertThat(result[Rank.None]).isEqualTo(1)
    }

    @Test
    @DisplayName("등수 리스트의 총 상금을 정확히 계산한다")
    fun `totalPrice는 전체 당첨 상금 합계를 계산한다`() {
        // given
        val ranks = listOf(
            Rank.First,   // 2,000,000,000
            Rank.Third,   // 1,500,000
            Rank.Fourth,  // 50,000
            Rank.Fifth    // 5,000
        )

        // when
        val totalPrize = calculator.totalPrice(ranks)

        // then
        assertThat(totalPrize).isEqualTo(2_001_555_000)
    }

    @Test
    @DisplayName("수익률을 올바르게 계산한다")
    fun `rate는 총 상금과 투자 금액을 기반으로 수익률을 계산한다`() {
        // given
        val ranks = listOf(
            Rank.Fourth, // 50,000
            Rank.Fifth,  // 5,000
            Rank.None    // 0
        )
        val gameCnt = 3 // 3장 구매 → 3,000원 투자

        // when
        val rate = calculator.rate(ranks, gameCnt)

        // then
        // (50,000 + 5,000) / 3,000 * 100 = 1833.33...
        assertThat(rate).isCloseTo(1833.33, within(0.01))
    }

    @Test
    @DisplayName("모든 Rank가 NONE일 경우 수익률은 0%이다")
    fun `모든 로또가 꽝이면 수익률 0`() {
        // given
        val ranks = List(5) { Rank.None } // 5장 전부 꽝
        val gameCnt = 5

        // when
        val rate = calculator.rate(ranks, gameCnt)

        // then
        assertThat(rate).isEqualTo(0.0)
    }
}
