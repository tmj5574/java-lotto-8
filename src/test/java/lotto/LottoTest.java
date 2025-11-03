package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("입력한 당첨 번호와 로또 번호를 비교하여 일치하는 개수를 반환한다.")
    void 일치하는_로또_번호_개수_확인(){
        //given
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,7,8,9));

        //when
        int matchCount = myLotto.countMatchingNumbers(winningLotto);

        //then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 로또 번호에 포함되어 있으면 true를 반환한다.")
    void 보너스_번호_일치_여부_확인1() {
        //given
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        //when
        boolean result = myLotto.contains(bonusNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 로또 번호에 포함되어 있지 않으면 false를 반환한다.")
    void 보너스_번호_일치_여부_확인2() {
        //given
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        boolean result = myLotto.contains(bonusNumber);

        //then
        assertThat(result).isEqualTo(false);
    }

}
