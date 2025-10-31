package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Validator validator;
    private final Output output;

    public Input(Validator validator, Output output) {
        this.validator = validator;
        this.output = output;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                output.printPurchasePrompt();
                String input = Console.readLine();
                validator.validatePurchaseAmount(input);

                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
