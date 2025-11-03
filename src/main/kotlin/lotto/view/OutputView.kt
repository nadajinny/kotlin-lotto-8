package lotto.view

interface OutputView {
    fun printPurchasePayment() {}
    fun printWinningNumber() {}
    fun printBonusNumber() {}
    fun printPurchasedNumber(gameCnt: Int) {}
    fun printLottoNumbers(numbers: String) {}
    fun printLottoResult() {}
    fun printProfitRate(profitRate: Double) {}
}
