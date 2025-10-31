package lotto;

import java.util.List;

public class Output {
    private final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private final String USER_NUMBERS_PROMPT = "당첨번호를 입력해주세요.";
    private final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public void printPurchasePrompt() {
        System.out.println(PURCHASE_PROMPT);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto l : lottoNumbers) {
            System.out.println(l.getLottoNumbersString());
        }
    }

    public void printUserLottoNumbersPrompt() {
        System.out.println(USER_NUMBERS_PROMPT);
    }

    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }
}
