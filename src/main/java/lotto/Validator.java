package lotto;

public class Validator {

    private static final String ERROR_NOT_1000_UNIT = "[ERROR] 구매 금액은 0원 초과 및 1000원의 배수여야 합니다.";
    private static final String ERROR_NOT_LETTER = "[ERROR] 숫자를 입력해야 합니다.";

    public void validatePurchaseAmount(String purchaseAmount) {
        int amount;

        try{
            amount = Integer.parseInt(purchaseAmount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_LETTER);
        }
        if (amount % 1000 != 0 || amount <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_1000_UNIT);
        }
    }
}
