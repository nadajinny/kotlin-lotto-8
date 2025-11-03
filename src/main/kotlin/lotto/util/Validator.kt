package lotto.util

import lotto.model.Lotto

object Validator {

    fun ofPayment(input: String): Int {
        require(input.isNotBlank()) { ErrorMessages.PAYMENT_BLANK }
        val payment = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.PAYMENT_FORMAT_INVALID)
        require(payment >= LottoConfig.LottoPrice) { ErrorMessages.PAYMENT_LESS_THAN_1000 }
        return payment
    }

    fun ofWinningNumber(input: String): Lotto {
        require(input.isNotBlank()) { ErrorMessages.WINNING_NUMBER_BLANK }
        val number = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        val winningNumber = Lotto(number)
        return winningNumber
    }

    fun ofBonusNumber(input: String, winningNumber: Lotto): Int {
        require(input.isNotBlank()) { ErrorMessages.BONUS_NUMBER_BLANK }
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER)
        require(bonus in LottoConfig.startNum..LottoConfig.endNum) { ErrorMessages.INVALID_BONUS_NUMBER }
        require(!winningNumber.contains(bonus)) { ErrorMessages.BONUS_NUMBER_SAME_WINNING_NUMBER }
        return bonus
    }
}