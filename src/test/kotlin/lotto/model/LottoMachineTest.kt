package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    @DisplayName("createLottos는 지정된 개수만큼 로또를 생성한다")
    fun `로또 생성 개수 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lottos = LottoMachine.createLottos(3)
                assertThat(lottos).hasSize(3)
            },
            // 랜덤 결과를 고정시킴
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12),
            listOf(13, 14, 15, 16, 17, 18)
        )
    }

}
