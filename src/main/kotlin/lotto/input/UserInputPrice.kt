package lotto.input

import camp.nextstep.edu.missionutils.Console

class UserInputPrice {
    private var inputPrice: String = ""

    init {
        input()
    }

    private fun input(){
        println("구입금액을 입력해주세요.")
        inputPrice = Console.readLine()
    }

    fun getInput() = inputPrice
}