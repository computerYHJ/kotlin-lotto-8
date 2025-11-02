package lotto.validator

class BonusValidator(private val bonus: String, private val winner: List<Int>) {
    private var bonusNumber: Int = -1

    init {
        validatorNoNumber()
        validatorNumberRange()
        bonusInWinner()
    }

    private fun validatorNoNumber(){
        try{
            bonusNumber = bonus.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.")
        }
    }

    private fun validatorNumberRange(){
        require(bonusNumber in 1..45){"[ERROR] 로또 범위에 맞는 숫자를 입력해주세요."}
    }

    private fun bonusInWinner(){
        require(!winner.contains(bonusNumber)) {"[ERROR] 당첨번호와 같은 행운번호 입니다."}
    }

    fun getUserBonus(): Int = bonusNumber
}