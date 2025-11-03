package lotto.util

import lotto.model.Lotto

object Validator {

    fun ofPayment(input: String): Int {
        require(input.isNotBlank()) { ErrorMessages.PAYMENT_BLANK }
        val payment = input.toInt()
        require(payment >= LottoConfig.LottoPrice) { ErrorMessages.PAYMENT_LESS_THAN_1000 }
        return payment
    }

    fun ofWinningNumber(input: String): Lotto {
        require(input.isNotBlank()) { ErrorMessages.WINNING_NUMBER_BLANK }
        val number = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        //수정 필요 -> size를 두번 확인함.
        require(number.size == LottoConfig.LOTTO_SIZE) { ErrorMessages.WINNING_NUMBER_COUNT_ERROR }
        require(number.all { it in LottoConfig.startNum..LottoConfig.endNum }) { ErrorMessages.INVALID_WINNING_NUMBER }
        require(number.distinct().size == LottoConfig.LOTTO_SIZE) { ErrorMessages.WINNING_NUMBER_REPETE }
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