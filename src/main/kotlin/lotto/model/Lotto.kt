package lotto.model

import lotto.util.ErrorMessages
import lotto.util.LottoConfig

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessages.WINNING_NUMBER_COUNT_ERROR }
        require(numbers.all { it in LottoConfig.startNum..LottoConfig.endNum }) { ErrorMessages.INVALID_WINNING_NUMBER }
        require(numbers.distinct().size == LottoConfig.LOTTO_SIZE) { ErrorMessages.WINNING_NUMBER_REPETE }
    }

    fun match(winningNumber: Lotto, bonusNumber: Int) : Rank {
        val winningMatch = numbers.count { it in winningNumber.numbers }
        val bonusMatch = bonusNumber in numbers
        return Rank.of(winningMatch, bonusMatch)
    }

    fun contains(number: Int) : Boolean {
        return number in numbers
    }

    fun getNumbers() : String {
        return numbers.joinToString(", ", "[", "]")
    }

    // TODO: 추가 기능 구현
}