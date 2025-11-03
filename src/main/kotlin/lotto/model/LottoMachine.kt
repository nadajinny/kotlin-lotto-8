package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.LottoConfig
import lotto.view.ConsoleOutputView

//로또를 만드는 일만 작업
object LottoMachine {
    fun createLottos(cnt: Int): List<Lotto> {
        val Lottos = (1..cnt).map {
            Lotto(Randoms.pickUniqueNumbersInRange(LottoConfig.startNum, LottoConfig.endNum, LottoConfig.LOTTO_SIZE))
        }
        val output = ConsoleOutputView()
        Lottos.forEach{ myLotto ->
            output.printLottoNumbers(myLotto.getNumbers()) }
        return Lottos
    }
}