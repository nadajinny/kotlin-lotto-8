package lotto.view

import lotto.util.OutputMessages

class ConsoleOutputView: OutputView {
    override fun printPurchasePayment() {
        println(OutputMessages.PROMPT_PURCHASE_PAYMENT)
    }

    override fun printWinningNumber() {
        println(OutputMessages.PROMPT_WINNING_NUMBER)
    }

    override fun printBonusNumber() {
        println(OutputMessages.PROMPT_BONUS_NUMBER)
    }

    override fun printPurchasedNumber(gameCnt: Int) {
        println("${gameCnt}${OutputMessages.PROMPT_PURCHASE_AMOUNT}")
    }

    override fun printLottoNumbers(numbers: String) {
        println(numbers)
    }

    override fun printLottoResult() {
        println(OutputMessages.PROMPT_LOTTO_RESULT)

    }

    override fun printProfitRate(profitRate: Double) {
        println("총 수익률은 %.1f%%입니다.".format(profitRate))
    }

}