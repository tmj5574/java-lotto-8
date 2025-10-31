package lotto;

import java.util.List;

public class Validator {

    private static final String ERROR_NOT_1000_UNIT = "[ERROR] 구매 금액은 0원 초과 및 1000원의 배수여야 합니다.";
    private static final String ERROR_NOT_LETTER = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String NUMBER_COUNT_NOT_6 = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String SAME_NUMBER_EXISTS = "중복된 요소가 있습니다! 예외 발생시키기";

    public static void validatePurchaseAmount(String purchaseAmount) {
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

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT_NOT_6);
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(SAME_NUMBER_EXISTS);
        }
    }
}
