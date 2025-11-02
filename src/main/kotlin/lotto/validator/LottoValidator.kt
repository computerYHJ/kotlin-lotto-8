package lotto.validator

class LottoValidator (private val winner: String){
    private var winnerNumber: List<Int> = emptyList()

    private fun validatorNoNumber(){
        try{
            winnerNumber = winner.split(",").map{it.trim().toInt()}
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.")
        }
    }

    private fun validatorNumberRange(){
        require(winnerNumber.all {it in 1..45}){"[ERROR] 로또 범위에 맞는 숫자를 입력해주세요."}
    }

    fun check() {
        validatorNoNumber()
        validatorNumberRange()
        Lotto(winnerNumber)
    }

    fun getUserWinner(): List<Int> = winnerNumber
}