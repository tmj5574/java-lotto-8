package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String ERROR_NOT_1000_UNIT = "[ERROR] 구매 금액은 0원 초과 및 1000원의 배수여야 합니다.";
    private static final String ERROR_NOT_LETTER = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String NUMBER_COUNT_NOT_6 = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String SAME_NUMBER_EXISTS = "중복된 요소가 있습니다! 예외 발생시키기";
    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 로또 번호는 숫자를 입력해야 합니다.";
    private static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복일 수 없습니다.";

    public static void validatePurchaseAmount(String purchaseAmount) {
        int amount;

        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(SAME_NUMBER_EXISTS);
        }
    }

    public static void validateUserLottoNumbers(String numbers) {

        String[] parts = numbers.split(",");

        if (parts.length != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT_NOT_6);
        }

        List<Integer> numberList = new ArrayList<>();
        for (String part : parts) {
            int num;

            try {
                num = Integer.parseInt(part.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
            }

            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
            }

            numberList.add(num);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numberList);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> userLottoNumbers) {
        int num;
        try {
            num = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
        if (userLottoNumbers.contains(num)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }
}
