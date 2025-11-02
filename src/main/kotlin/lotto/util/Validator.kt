package lotto.util

import lotto.util.ErrorMessages
import lotto.util.ErrorMessages.INVALID_BONUS_NUMBER

object Validator {
    var LottoPrice = 1000
    fun ofPayment(input: String): Int {
        require(input.isNotBlank()) { ErrorMessages.PAYMENT_BLANK }
        val payment = input.toInt()
        require(payment >= LottoPrice) { ErrorMessages.PAYMENT_LESS_THAN_1000 }
        return payment
    }

    fun ofWinningNumber(input: String): List<Int> {
        require(input.isNotBlank()) { ErrorMessages.WINNING_NUMBER_BLANK }
        val number = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        require(number.size == 6) { ErrorMessages.WINNING_NUMBER_COUNT_ERROR }
        require(number.all { it in 1..45 }) { ErrorMessages.INVALID_WINNING_NUMBER }
        require(number.distinct().size == 6) { ErrorMessages.WINNING_NUMBER_REPETE }
        return number
    }

    fun ofBonusNumber(input: String, winningNumber: List<Int>): Int {
        require(input.isNotBlank()) { ErrorMessages.BONUS_NUMBER_BLANK }
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException(INVALID_BONUS_NUMBER)
        require(bonus in 1..45) { ErrorMessages.INVALID_BONUS_NUMBER }
        require(!winningNumber.contains(bonus)) { ErrorMessages.BONUS_NUMBER_SAME_WINNING_NUMBER }
        return bonus
    }
}