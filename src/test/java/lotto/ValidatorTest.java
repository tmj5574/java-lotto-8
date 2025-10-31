package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = new Validator();
    }

    @Test
    void 구매_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("paramsForPurchaseInvalidInputs")
    void 구매_금액이_올바르지_않은_경우_예외가_발생한다(String purchaseAmount) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> paramsForPurchaseInvalidInputs() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("-5000"),
                Arguments.of("abc")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForUserLottoInputs")
    void 입력한_로또_번호가_올바르지_않은_경우_예외가_발생한다(String userLottoInputs) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(userLottoInputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> paramsForUserLottoInputs() {
        return Stream.of(
                Arguments.of("1,2,3,4"),
                Arguments.of("a,b,c"),
                Arguments.of("0,1,3,5,46")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForUserBonusInputs")
    void 입력한_보너스_번호가_올바르지_않은_경우_예외가_발생한다(String userBonusInputs, List<Integer> userLottoNumbers) {
        assertThatThrownBy(() -> validator.validateBonusNumber(userBonusInputs, userLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> paramsForUserBonusInputs() {
        List<Integer> defaultWinningNumbers = List.of(1, 2, 3, 4, 5, 8);
        return Stream.of(
                Arguments.of("-1", defaultWinningNumbers),
                Arguments.of("50", defaultWinningNumbers),
                Arguments.of("-", defaultWinningNumbers),
                Arguments.of("-6", List.of(1,2,4,5,6,7))
        );
    }


}
