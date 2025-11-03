package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {

    public static List<Lotto> buyLottos(int money) {
        int lottoAmount = calculateLottoAmount(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = getRandomNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int calculateLottoAmount(int money) {
        return money / 1000;
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Map<Rank, Integer> calculateStatistics(List<Lotto> myLottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> statisticsMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                statisticsMap.put(rank, 0);
            }
        }

        for (Lotto myLotto : myLottos) {

            int matchCount = myLotto.countMatchingNumbers(winningLotto);
            boolean matchBonus = myLotto.contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, matchBonus);

            if (rank != Rank.MISS) {
                statisticsMap.put(rank, statisticsMap.get(rank) + 1);
            }
        }

        return statisticsMap;
    }
}
