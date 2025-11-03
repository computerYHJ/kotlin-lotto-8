package lotto.validator

import java.lang.IllegalArgumentException

object InputValidator {
    fun validatorPrice(input: String): Int {
        val price = validatorNoNum(input)
        validatorPriceRange(price)
        return price
    }

    fun validatorLotto(input: String): List<Int>{
        var winnerNumber: List<Int> = emptyList()

        winnerNumber = input.split(",").map {
            validatorNoNum(it) }

        winnerNumber.map{validatorLottoRange(it)}
        Lotto(winnerNumber)
        return winnerNumber
    }

    fun validatorBonus(input: String, winner: List<Int>): Int{
        val bonusNumber = validatorNoNum(input)

        validatorLottoRange(bonusNumber)

        require(!winner.contains(bonusNumber)) {"[ERROR] 당첨번호와 같은 행운번호 입니다."}

        return bonusNumber
    }

    fun validatorNoNum(input: String): Int{
        return input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.")
    }

    fun validatorLottoRange(input: Int){
        require(input in 1..45){"[ERROR] 로또 범위에 맞는 숫자를 입력해주세요."}
    }

    fun validatorPriceRange(input: Int){
        require(input > 999) { "[ERROR] 입력된 금액은 1000원 이상이어야 합니다." }
        require(input % 1000 == 0) { "[ERROR] 입력된 금액은 1000원 단위어야 합니다." }

    }
}