package lotto.input

import camp.nextstep.edu.missionutils.Console.readLine

object UserInput {
    fun userInputPrice(): String{
        println("구입금액을 입력해주세요.")
        return readLine()
    }

    fun userInputLotto(): String{
        println("당첨번호를 입력해주세요.")
        return readLine()
    }

    fun userInputBonus(): String{
        println("보너스 번호를 입력해주세요.")
        return readLine()
    }
}