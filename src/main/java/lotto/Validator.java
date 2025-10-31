package lotto;

public class Validator {

    private static final String ERROR_NOT_1000_UNIT = "ERROR] 구매 금액은 0원 초과 및 1000원의 배수여야 합니다.";

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0 || purchaseAmount == 0) {
            throw new IllegalArgumentException(ERROR_NOT_1000_UNIT);
        }
    }
}
