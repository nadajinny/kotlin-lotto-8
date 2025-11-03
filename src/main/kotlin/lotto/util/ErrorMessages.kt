package lotto.util

object ErrorMessages {
    const val PAYMENT_BLANK = "[ERROR] 구입 금액이 입력되지 않았습니다."
    const val PAYMENT_FORMAT_INVALID = "[ERROR] 구입 금액이 잘못 작성되어 있습니다."
    const val PAYMENT_LESS_THAN_1000 = "[ERROR] 구입 금액이 1000원보다 낮습니다."
    const val WINNING_NUMBER_BLANK = "[ERROR] 당첨 번호가 입력되지 않았습니다."
    const val WINNING_NUMBER_COUNT_ERROR = "[ERROR] 당첨 번호가 6개가 아닙니다."
    const val WINNING_NUMBER_REPETE = "[ERROR] 중복된 당첨 번호가 있습니다."
    const val INVALID_WINNING_NUMBER = "[ERROR] 당첨 번호가 1~45 사이의 숫자가 아닙니다."
    const val INVALID_BONUS_NUMBER = "[ERROR] 당첨 번호가 1~45 사이의 숫자가 아닙니다."
    const val BONUS_NUMBER_SAME_WINNING_NUMBER = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."
    const val BONUS_NUMBER_BLANK = "[ERROR] 보너스 번호가 제대로 입력되지 않았습니다."
}