package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.enumeration.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또를 지정된 개수만큼 구매한다.")
    @Test
    void purchase() {
        final List<Lotto> lottos = new ArrayList<>();

        final Integer lottoCount = 3;
        lottoService.purchase(lottoCount, lottos);

        assertThat(lottos).hasSize(lottoCount);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @DisplayName("비용을 로또 개수로 바꾼다.")
    @Test
    void costToLottoCount() {
        final Long cost = 5000L;
        final LottoNumber price = LottoNumber.PRICE;

        final Integer count = lottoService.costToLottoCount(cost, price);

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("로또 리스트를 통계화하고, 결과를 확인한다.")
    @Test
    void makeStatistic() {
        final Lotto lotto1 = new Lotto(List.of(1, 2, 3, 10, 20, 30));
        final Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        final List<Lotto> lottos = List.of(lotto1, lotto2);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        final Integer bonusNumber = 6;

        final Statistic statistic = lottoService.makeStatistic(lottos, winningNumbers, bonusNumber);

        assertThat(statistic.getHitThree()).isEqualTo(1);
        assertThat(statistic.getHitFour()).isEqualTo(0);
        assertThat(statistic.getHitFiveWithoutBonus()).isEqualTo(0);
        assertThat(statistic.getHitFiveWithBonus()).isEqualTo(1);
        assertThat(statistic.getHitSix()).isEqualTo(0);
    }

    @DisplayName("총 수익과 비용이 주어졌을 때, 수익률을 계산한다.")
    @Test
    void calculateRateOfReturn() {
        final Long profit = 8000L;
        final Long cost = 10000L;

        final Double rate = lottoService.calculateRateOfReturn(profit, cost);

        assertThat(rate).isEqualTo(80.0);
    }
}