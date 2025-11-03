package lotto

import lotto.input.UserInputPrice
import lotto.output.BuyLottoPaper
import lotto.validator.BonusValidator
import lotto.validator.InputPriceValidator
import lotto.validator.InputValidator
import lotto.validator.Lotto
import lotto.validator.LottoValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `입력한 값이 없다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorNoNum("")
        }
    }

    @Test
    fun `입력한 값이 공백이라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorNoNum(" ")
        }
    }

    @Test
    fun `입력한 값이 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorNoNum("abc")
        }
    }

    @Test
    fun `입력한 금액이 1000원 미만이면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorPriceRange(999)
        }
    }

    @Test
    fun `입력한 금액이 1000원 단위가 아니라면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorPriceRange(1100)
        }
    }

    @Test
    fun `금액에 맞는 로또를 구입한다`(){
        var lottoPaper = BuyLottoPaper(5000)

        assertEquals(5, lottoPaper.getLottoCount())
        assertEquals(5, lottoPaper.getLottoPaper().size)
    }

    @Test
    fun `구입한 각각의 로또번호들은 6가지 숫자를 가져야 한다`(){
        var lottoPaper = BuyLottoPaper(5000)

        lottoPaper.getLottoPaper().forEach { lotto ->
            assertEquals(6, lotto.size)
        }
    }

    @Test
    fun `구입한 각각의 로또번호들은 로또숫자 범위에 맞는 숫자들이다`(){
        var lottoPaper = BuyLottoPaper(2000)

        lottoPaper.getLottoPaper().forEach { lotto ->
            assertTrue { lotto.all{it in 1..45} }
        }
    }
    @Test
    fun `구입한 각각의 로또번호들은 중복된 수를 가지지 않는다`(){
        var lottoPaper = BuyLottoPaper(5000)

        lottoPaper.getLottoPaper().forEach { lotto ->
            assertEquals(lotto.size, lotto.toSet().size)
        }
    }

    @Test
    fun `입력한 당첨번호중 숫자가 아니면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorNoNum("1, 2, 3, abc, 5, 6")
        }
    }
    @Test
    fun `입력한 당첨번호중 로또의 범위를 벗어나면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorLotto("1, 2, 3, 46, 5, 6")
        }
    }

    @Test
    fun `행운번호가 로또번호 범위를 벗어난다면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorBonus("46", listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `행운번호가 로또번호와 중복된다면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            InputValidator.validatorBonus("1", listOf(1,2,3,4,5,6))
        }
    }

}
