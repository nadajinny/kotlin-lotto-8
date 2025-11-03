package lotto.controller

import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import lotto.util.Validator
import lotto.model.LottoMachine
import lotto.model.Rank
import lotto.util.LottoConfig
import lotto.util.ProfitCalculator

class LottoController(
    private val input: InputView,
    private val output: OutputView,
) {
    public fun run() {
        val (gameCnt, winningNumber, bonusNumber) = collectUserInput()
        val myLottos : List<Lotto> = LottoMachine.createLottos(gameCnt)
        val matchResult: List<Rank> = myLottos.map { myLotto ->
            myLotto.match(winningNumber, bonusNumber)
        }
        resultLotto(matchResult, gameCnt)
    }
    private fun collectUserInput(): Triple<Int, Lotto, Int> {
        val payment = readValidPayment()
        val gameCnt = payment/ LottoConfig.LottoPrice
        val winningNumber: Lotto = readValidWinningNumber()
        val bonusNumber = readValidBonusNumber(winningNumber)
        output.printPurchasedNumber(gameCnt)
        return Triple(gameCnt, winningNumber, bonusNumber)
    }

    private fun readValidPayment(): Int {
        while(true) {
            try{
                output.printPurchasePayment()
                val payment = input.readLine()
                return Validator.ofPayment(payment)
            }catch(e: IllegalArgumentException){
                println("${e.message}")
            }
        }
    }

    private fun readValidWinningNumber(): Lotto {
        while(true) {
            try{
                output.printWinningNumber()
                val winningNumber = input.readLine()
                return Validator.ofWinningNumber(winningNumber)
            }catch(e: IllegalArgumentException){
                println("${e.message}")
            }
        }
    }

    private fun readValidBonusNumber(winningNumber: Lotto): Int {
        while(true) {
            try{
                output.printBonusNumber()
                val bonusNumber = input.readLine()
                return Validator.ofBonusNumber(bonusNumber, winningNumber)
            }catch(e: IllegalArgumentException){
                println("${e.message}")
            }
        }
    }

    private fun resultLotto(matchResult: List<Rank>, payment: Int) {
        val profitCalculator = ProfitCalculator()
        val rankCount = profitCalculator.rankCount(matchResult)
        val Rate = profitCalculator.rate(matchResult, payment)
        output.printLottoResult()
        Rank.entries.forEach { rank ->
            val count = rankCount[rank] ?: 0
            println("${rank.message}${count}개")
        }
        output.printProfitRate(Rate)
    }
}