package lotto.output

import lotto.input.UserBonusInput
import lotto.input.UserInput
import lotto.input.UserLottoInput
import lotto.validator.BonusValidator
import lotto.validator.InputValidator
import lotto.validator.LottoValidator

class UserLotto {
    private var winnerNumber: List<Int> = emptyList()
    private var bonusNumber: Int = -1
//    private var lotto: LottoValidator = LottoValidator(UserLottoInput().getInput())

    init {
        repeatLottoRun()
    }

    private fun repeatLottoRun() {
        while (true) {
            if (getCorrectLotto() == 1) break
        }
        while (true) {
            if (getCorrectBonus() == 1) break
        }
    }

    private fun getCorrectLotto(): Int {
        try {
//            lotto.check()
//            winnerNumber = lotto.getUserWinner()
            winnerNumber = InputValidator.validatorLotto(UserInput.userInputLotto())
            return 1
        } catch (e: IllegalArgumentException) {
            println(e.message);
            return 0
        }
    }

    private fun getCorrectBonus(): Int {
        try {
            bonusNumber = InputValidator.validatorBonus(UserInput.userInputBonus(), winnerNumber)
            return 1
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return 0
        }
    }

    fun getWinner(): List<Int> = winnerNumber
    fun getBonus(): Int = bonusNumber

}