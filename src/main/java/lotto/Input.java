package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Validator validator;

    public Input(Validator validator) {
        this.validator = validator;
    }

    public int getPurchaseAmount() {
        try {
            int input = Integer.parseInt(Console.readLine());
            validator.validatePurchaseAmount(input);

            return input;

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
