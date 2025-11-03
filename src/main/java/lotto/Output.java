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

        // 1. 정해진 순서(5등~1등)대로 출력하기 위해 배열을 만듭니다.
        // (Rank.values()는 FIRST부터 시작하므로 순서가 맞지 않습니다.)
        Rank[] displayRanks = {
                Rank.FIFTH,  // 3개 일치
                Rank.FOURTH, // 4개 일치
                Rank.THIRD,  // 5개 일치
                Rank.SECOND, // 5개 일치, 보너스 볼 일치
                Rank.FIRST   // 6개 일치
        };

        // 2. 이 순서대로 반복
        for (Rank rank : displayRanks) {
            // 맵에서 해당 등수의 당첨 횟수를 가져옵니다. (없으면 0)
            int count = statisticsMap.getOrDefault(rank, 0);

            // Enum에서 포맷팅된 문자열을 가져옵니다.
            // "3개 일치 (5,000원) - 1개"
            System.out.printf("%s (%s원) - %d개\n",
                    rank.getDescription(),          // "3개 일치"
                    rank.getFormattedPrizeMoney(),  // "5,000"
                    count                           // 1
            );
        }

        // 3. 수익률 출력 (소수점 둘째 자리에서 반올림 -> .1f)
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
