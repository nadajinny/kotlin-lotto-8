package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView

fun main() {
    // TODO: 프로그램 구현
    val inputView = ConsoleInputView()
    val outputView = ConsoleOutputView()

    val controller = LottoController(inputView, outputView)
    controller.run()
}
