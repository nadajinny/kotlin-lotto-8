package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.util.Validator

class LottoController(
    private val input: InputView,
    private val output: OutputView,
) {
    public fun run() {
        val (gameCnt, winningNumber, bonusNumber) = collectUserInput()

    }
    private fun collectUserInput(): Triple<Int, List<Int>, Int> {
        val payment = readValidPayment()
        val gameCnt = payment/ Validator.LottoPrice
        val winningNumber = readValidWinningNumber()
        val bonusNumber = readValidBonusNumber(winningNumber)
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

    private fun readValidWinningNumber(): List<Int> {
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

    private fun readValidBonusNumber(winningNumber: List<Int>): Int {
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
}