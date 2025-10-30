package lotto;

public class Validator {
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 음수일 수 없습니다.");
        }
        if (purchaseAmount % 1000 != 0 || purchaseAmount == 0 ) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0 초과의 1000원의 배수여야 합니다.");
        }
    }
}
