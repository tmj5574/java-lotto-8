package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getUserLottoNumbers() {
        while (true) {
            try {
                output.printUserLottoNumbersPrompt();
                String input = Console.readLine();
                Validator.validateUserLottoNumbers(input);

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)         // " 1" 같은 공백 제거
                        .map(Integer::parseInt)    // 숫자로 변환
                        .toList();

                return numbers;

            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> userLottoNumbers) {
        while (true) {
            try {
                output.printBonusNumberPrompt();
                String input = Console.readLine();
                Validator.validateBonusNumber(input, userLottoNumbers);
                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
