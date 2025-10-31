package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public static List<Lotto> buyLottos(int money) {
        int lottoAmount = calculateLottoAmount(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(getRandomNumbers()));
        }
        return lottos;
    }

    private static int calculateLottoAmount(int money) {
        return money / 1000 ;
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
