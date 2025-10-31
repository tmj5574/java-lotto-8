package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액 8000원에 해당하는 8개의 로또를 발행한다.")
    void 로또_개수_확인() {
        // given
        LottoService lottoService = new LottoService();
        int money = 8000;

        // when
        // buyLottos를 호출하면 8개의 로또가 담긴 리스트가 나와야 함
        List<Lotto> purchasedLottos = lottoService.buyLottos(money);

        // then
        // 1. 리스트의 크기가 8인지 확인한다.
        assertThat(purchasedLottos).hasSize(8);

        // 2. 리스트의 모든 요소가 Lotto 클래스의 인스턴스인지 확인한다.
        assertThat(purchasedLottos).allSatisfy(lotto -> {
            assertThat(lotto).isInstanceOf(Lotto.class);
        });
    }
}
