package lotto.output

class CalculatorWinCount(
    private val count: Int, private val lottoPaper: Array<List<Int>>,
    private val userChoiceNumber: List<Int>, private val userChoiceLuckyNumber: Int
) {
    private var recordWinCount: Array<Int> = Array<Int>(5, {0})

    init {
        result()
    }
    private fun result() {
        for (i in 0 until count) { record(i) }
    }

    private fun record(index: Int) {
        var correctCount: Int = 0
        correctCount = findCount(lottoPaper[index], userChoiceNumber,
            userChoiceLuckyNumber)
        if(correctCount >= 3) recordWinCount[correctCount - 3]++

    }

    private fun findCount(LottoPaper: List<Int>, UserLottoNumber: List<Int>, UserLottoLuckyNumber: Int): Int {
        var matchCount: Int = UserLottoNumber.count { it in LottoPaper }
        var luckyCount = UserLottoLuckyNumber in LottoPaper
        return when{
            matchCount == 5 && luckyCount -> 6
            matchCount == 6 -> 7
            else -> matchCount
        }
    }

    fun getRecordWinCount(): Array<Int> = recordWinCount
}