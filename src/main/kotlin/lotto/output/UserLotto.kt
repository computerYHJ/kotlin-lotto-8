package lotto.output

import lotto.input.UserBonusInput
import lotto.input.UserLottoInput
import lotto.validator.BonusValidator
import lotto.validator.LottoValidator

class UserLotto {
    private var winnerNumber: List<Int> = emptyList()
    private var bonusNumber: Int = -1
    private var lotto: LottoValidator = LottoValidator(UserLottoInput().getInput())

    init {
        repeatLottoRun()
    }
    private fun repeatLottoRun() {
        while (true) {
            if (getCorrectLotto() == 1 && getCorrectBonus() == 1) break
        }
    }

    private fun getCorrectLotto(): Int{
        try{
            lotto.check()
            winnerNumber = lotto.getUserWinner()
            return 1
        } catch (e: IllegalArgumentException) {
            println(e.message);
            lotto = LottoValidator(UserLottoInput().getInput())
            return 0 }
    }

    private fun getCorrectBonus(): Int{
        try{
            bonusNumber = BonusValidator(UserBonusInput().getInput(), winnerNumber).getUserBonus()
            return 1
        } catch (e: IllegalArgumentException){
            println(e.message)
            return 0
        }
    }

    fun getWinner(): List<Int> = winnerNumber
    fun getBonus(): Int = bonusNumber

}