package lotto.controller

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoControllerTest : NsTest() {

    @Test
    fun `LottoController 정상 동작 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                // 입력 순서: 구입 금액 → 당첨 번호 → 보너스 번호
                run("8000", "1,2,3,4,5,6", "7")

                assertThat(output()).contains(
                    "구입금액을 입력해 주세요.",
                    "8개를 구매했습니다.",
                    "당첨 번호를 입력해 주세요.",
                    "보너스 번호를 입력해 주세요.",
                    "당첨 통계",
                    "3개 일치 (5,000원)",
                    "4개 일치 (50,000원)",
                    "5개 일치 (1,500,000원)",
                    "5개 일치, 보너스 볼 일치 (30,000,000원)",
                    "6개 일치 (2,000,000,000원)",
                    "총 수익률은"
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `로또 구입 금액이 숫자가 아니면 예외 발생`() {
        assertSimpleTest {
            runException("1ooo0", "1,2,3,4,5,6", "7") // 'o' 포함
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액이 1000원 단위가 아니면 예외 발생`() {
        assertSimpleTest {
            runException("750")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 범위를 벗어나면 예외 발생`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "100")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        // LottoController를 직접 실행하도록 main 대신 아래 코드를 수행
        val input = ConsoleInputView()
        val output = ConsoleOutputView()
        val controller = LottoController(input, output)
        controller.run()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
