package lotto.input

import camp.nextstep.edu.missionutils.Console

class UserBonusInput {
    private var bonusNumber: String = ""

    init {
        input()
    }

    private fun input(){
        println("행운 번호를 입력해 주세요.")
        bonusNumber = Console.readLine()
    }

    fun getInput() = bonusNumber
}