package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액 8000원에 해당하는 8개의 로또를 발행한다.")
    void 로또_개수_확인() {
        LottoService lottoService = new LottoService();
        int money = 8000;

        // when
        List<Lotto> purchasedLottos = lottoService.buyLottos(money);

        // then
        assertThat(purchasedLottos).hasSize(8);
        assertThat(purchasedLottos).allSatisfy(lotto -> {
            assertThat(lotto).isInstanceOf(Lotto.class);
        });
    }

    @Test
    @DisplayName("등수별로 총 당첨 개수를 확인한다.")
    void 등수별_당첨_개수_확인() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 (1개)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등 (1개)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등 (1개)
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4등 (1개)
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),// 5등 (1개)
                new Lotto(List.of(1, 2, 3, 11, 12, 13)),// 5등 (2개)
                new Lotto(List.of(10, 11, 12, 13, 14, 15)), // 꽝 (1개)
                new Lotto(List.of(10, 11, 12, 13, 14, 16))  // 꽝 (2개)
        );

        // when
        Map<Rank, Integer> statisticsMap = LottoService.calculateStatistics(myLottos, winningLotto, bonusNumber);

        // then
        assertThat(statisticsMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(statisticsMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(statisticsMap.get(Rank.THIRD)).isEqualTo(1);
        assertThat(statisticsMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(statisticsMap.get(Rank.FIFTH)).isEqualTo(2);
        assertThat(statisticsMap.size()).isEqualTo(Rank.values().length - 1); // MISS 제외
    }


}
