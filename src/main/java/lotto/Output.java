package lotto;

import java.util.List;

public class Output {
    private final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";

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
}
