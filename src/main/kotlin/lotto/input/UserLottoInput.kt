package lotto.input

import camp.nextstep.edu.missionutils.Console

class UserLottoInput {
    private var winnerNumber: String = ""

    init {
        input()
    }

    private fun input(){
        println("당첨 번호를 입력해 주세요.")
        winnerNumber = Console.readLine()
    }

    fun getInput() = winnerNumber
}