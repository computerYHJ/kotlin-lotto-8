package lotto.output

import lotto.input.UserInput
import lotto.input.UserInputPrice
import lotto.validator.InputPriceValidator
import lotto.validator.InputValidator

class UserPrice {
    private var price: Int = 0
    init {
        repeatPriceRun()
    }

    private fun repeatPriceRun(){
        while (price == 0) { getCorrectPrice() }
    }

    private fun getCorrectPrice(){
        try{
            // price = InputPriceValidator(UserInputPrice().getInput()).getUserPrice()
            price = InputValidator.validatorPrice(UserInput.userInputPrice())
        } catch (e: IllegalArgumentException) { println(e.message) }
    }

    fun getPrice() = price
}