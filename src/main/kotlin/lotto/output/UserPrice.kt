package lotto.output

import lotto.input.UserInputPrice
import lotto.validator.InputPriceValidator

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
            price = InputPriceValidator(UserInputPrice().getInput()).getUserPrice()
        } catch (e: IllegalArgumentException) { println(e.message) }
    }
    fun getPrice() = price
}