package lotto.validator

import java.lang.IllegalArgumentException

object InputValidator {
    fun validatorPrice(input: String): Int {
        val price = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.")

        require(price > 999) { "[ERROR] 입력된 금액은 1000원 이상이어야 합니다." }
        require(price % 1000 == 0) { "[ERROR] 입력된 금액은 1000원 단위어야 합니다." }

        return price
    }

    fun validatorLotto(input: String): List<Int>{
        var winnerNumber: List<Int> = emptyList()

        winnerNumber = input.split(",").map {
            it.trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.") }

        require(winnerNumber.all{it in 1..45}){"[ERROR] 로또 범위에 맞는 숫자를 입력해주세요."}
        Lotto(winnerNumber)
        return winnerNumber
    }

    fun validatorBonus(input: String, winner: List<Int>): Int{
        val bonusNumber = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.")

        require(bonusNumber in 1..45) {"[ERROR] 로또 범위에 맞는 숫자를 입력해주세요."}

        require(!winner.contains(bonusNumber)) {"[ERROR] 당첨번호와 같은 행운번호 입니다."}

        return bonusNumber
    }
}