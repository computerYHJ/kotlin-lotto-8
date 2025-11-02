package lotto.output

import camp.nextstep.edu.missionutils.Randoms

class BuyLottoPaper(UserInputPrice: Int) {
    private var count: Int = UserInputPrice / 1000
    private var lottoPaper = Array<List<Int>>(count){listOf(1,2,3,4,5,6)}

    init {
        println("$count" + "개를 구매했습니다.")
        lottoPaper = createLottoPaper()
    }

    private fun createLottoPaper(): Array<List<Int>>{
        for(i in 0 until count) createOneLottoPaper(i)
        for(i in 0 until count) println(lottoPaper[i])
        return lottoPaper
    }

    private fun createOneLottoPaper(index: Int){
        lottoPaper[index] = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun getLottoPaper(): Array<List<Int>> = lottoPaper

    fun getLottoCount(): Int = count
}