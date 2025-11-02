package lotto.output

import lotto.PriceInformation

class PrintResult(private val winCount: Array<Int>, private val price: Int) {
    private var TotalPrice: Long = 0
    private var winForm: Array<PriceInformation> = PriceInformation.entries.toTypedArray()

    init {
        printWinStateBoard(winCount)
        calculator(winCount)
        printProfitRate()
    }

    private fun printWinStateBoard(winCount: Array<Int>) {
        println("당첨통계\n" + "---")
        winCount.forEachIndexed { index, i -> println(winForm[index].matchComment + " - " + winCount[index] + "개") }
    }

    private fun calculator(winCount: Array<Int>) {
        winCount.forEachIndexed { index, i -> if (i != 0) TotalPrice += (winForm[index].matchPrice * i) }
    }

    private fun printProfitRate() {
        val profitRate = (TotalPrice / price.toDouble()) * 100
        println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
    }

}