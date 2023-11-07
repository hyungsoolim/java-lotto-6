package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.lotto.DuplicateNumberException;
import lotto.exception.lotto.IllegalNumberCountException;
import lotto.exception.lotto.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalNumberCountException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외 발생")
    @Test
    void createLottoByLessSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalNumberCountException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호가 1보다 작은 숫자가 있으면 예외 발생")
    @Test
    void createLottoByLessRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(OutOfRangeException.class);
    }

    @DisplayName("로또 번호가 45보다 큰 숫자가 있으면 예외 발생")
    @Test
    void createLottoByOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(OutOfRangeException.class);
    }
}