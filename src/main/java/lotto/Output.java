package lotto;

import java.util.List;
import java.util.Map;

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
        System.out.println();
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (Lotto l : lottoNumbers) {
            System.out.println(l.getLottoNumbersString());
        }
    }

    public void printUserLottoNumbersPrompt() {
        System.out.println();
        System.out.println(USER_NUMBERS_PROMPT);
    }

    public void printBonusNumberPrompt() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public void printStatistics(Map<Rank, Integer> statisticsMap, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Rank[] displayRanks = {
                Rank.FIFTH,  // 3개 일치
                Rank.FOURTH, // 4개 일치
                Rank.THIRD,  // 5개 일치
                Rank.SECOND, // 5개 일치, 보너스 볼 일치
                Rank.FIRST   // 6개 일치
        };

        for (Rank rank : displayRanks) {
            int count = statisticsMap.getOrDefault(rank, 0);

            System.out.printf("%s (%s원) - %d개\n", rank.getDescription(), rank.getFormattedPrizeMoney(), count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
