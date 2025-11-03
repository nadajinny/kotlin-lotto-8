package lotto.util

import lotto.model.Rank

class ProfitCalculator {
    fun rankCount(ranks: List<Rank>): Map<Rank, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun totalPrice(ranks: List<Rank>): Int {
        return ranks.sumOf { it.prize }
    }

    fun rate(ranks: List<Rank>, gameCnt: Int): Double {
        val total = totalPrice(ranks)
        val spend = gameCnt* LottoConfig.LottoPrice

        return total / spend.toDouble() * 100.0
    }
}