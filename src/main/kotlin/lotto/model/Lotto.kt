package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun match(winningNumber: Lotto) : Int {
        return numbers.count { it in winningNumber.numbers }
    }

    fun contains(number: Int) : Boolean {
        return number in numbers
    }

    fun getNumbers() : List<Int> {
        return numbers
    }

    // TODO: 추가 기능 구현
}