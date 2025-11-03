package lotto.output

import lotto.input.UserInput
import lotto.validator.InputValidator

object UserInfo {

    private var price: Int = -1
    private var winnerNumber: List<Int> = emptyList()
    private var bonusNumber: Int = -1

    fun getPrice(): Int {
        while (price == -1) correctPrice()
        return price
    }

    fun correctPrice() {
        try {
            price = InputValidator.validatorPrice(UserInput.userInputPrice())
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun getWinNum(): List<Int> {
        while (winnerNumber.isEmpty()) correctWinNum()
        return winnerNumber
    }

    fun correctWinNum() {
        try {
            winnerNumber = InputValidator.validatorLotto(UserInput.userInputLotto())
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun getBonus(): Int {
        while (bonusNumber == -1) correctBonus()
        return bonusNumber
    }

    fun correctBonus() {
        try {
            bonusNumber = InputValidator.validatorBonus(UserInput.userInputBonus(), winnerNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}