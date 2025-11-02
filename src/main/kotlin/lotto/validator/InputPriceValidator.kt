package lotto.validator

class InputPriceValidator(private val inputPrice: String) {
    private var price: Int = -1
    init {
        validatorNoNumber()
        validatorWrongRange(price)
    }

    private fun validatorNoNumber() {
        try {
            price = inputPrice.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.")
        }
    }

    private fun validatorWrongRange(price: Int) {
        require(price > 999) { "[ERROR] 입력된 금액은 1000원 이상이어야 합니다." }
        require(price % 1000 == 0) { "[ERROR] 입력된 금액은 1000원 단위어야 합니다." }
    }

    //    init {
//        UserInputPrice = CurrectUserInputPrice()
//    }
//
//    private fun CurrectUserInputPrice(): Int{
//        var price: Int = 0
//        while (price == 0){
//            price = UserInputPriceErrorCheck()
//        }
//        return price
//    }
//
//    private fun UserInputPriceErrorCheck(): Int {
//        var price: Int = 0
//        try {
//            price = CheckNoNumberInput()
//            CheckWrongNumber(price)
//            return price
//        } catch (e: IllegalArgumentException){
//            println(e.message)
//            return 0
//        }
//    }
//
//    private fun CheckNoNumberInput(): Int{
//        println("구입금액을 입력해주세요.")
//        return readLine()?.toIntOrNull()
//            ?: throw IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.")
//
//    }
//
//    private fun CheckWrongNumber(UserInputPrice: Int){
//        when {
//            UserInputPrice < 1000 -> throw IllegalArgumentException("[ERROR] 입력된 금액은 1000원 이상이어야 합니다.")
//            UserInputPrice % 1000 != 0 -> throw IllegalArgumentException("[ERROR] 입력된 금액은 1000원 단위어야 합니다.")
//        }
//    }
//
    fun getUserPrice(): Int = price
}