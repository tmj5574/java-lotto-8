package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Output output;

    public Input(Output output) {
        this.output = output;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                output.printPurchasePrompt();
                String input = Console.readLine();
                Validator.validatePurchaseAmount(input);

                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
