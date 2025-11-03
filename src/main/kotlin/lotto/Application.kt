package lotto

import lotto.output.BuyLottoPaper
import lotto.output.CalculatorWinCount
import lotto.output.PrintResult
import lotto.output.UserInfo

fun main() {
    var price = UserInfo.getPrice()
    var buyLotto = BuyLottoPaper(price)

    var winCount: Array<Int> = CalculatorWinCount(
        buyLotto.getLottoCount(), buyLotto.getLottoPaper(),
        UserInfo.getWinNum(), UserInfo.getBonus()
    ).getRecordWinCount()

    PrintResult(winCount, price)
}
