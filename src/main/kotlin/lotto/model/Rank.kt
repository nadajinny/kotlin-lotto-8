package lotto.model

enum class Rank (
    val matchCnt: Int,
    val prize: Int,
    val message: String
) {
    First(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    Second(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Third(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    Fourth(4, 50_000, "4개 일치 (50,000원) - "),
    Fifth(3, 5_000, "3개 일치 (5,000원) - "),
    None(0, 0, "");

    companion object {
        fun of (matchCnt: Int, hasBonus: Boolean): Rank {
            return when {
                matchCnt == 6 -> First
                matchCnt == 5 && hasBonus -> Second
                matchCnt == 5 -> Third
                matchCnt == 4 -> Fourth
                matchCnt == 3 -> Fifth
                else -> None
            }
        }
    }
}