package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticTest {

    private Statistic statistic;

    @BeforeEach
    void init() {
        statistic = new Statistic();
    }

    @DisplayName("주어진_통계에_대해_수익을_계산한다")
    @Test
    void calculateProfit() {
        statistic.add(3L, false);
        statistic.add(4L, true);
        statistic.add(5L, false);
        statistic.add(5L, true);
        statistic.add(6L, false);

        long expectedResult = 2031555000L;

        assertThat(statistic.calculateProfit()).isEqualTo(expectedResult);
    }

    @DisplayName("통계를_추가한다")
    @Test
    void add() {
        statistic.add(3L, false);
        statistic.add(3L, false);
        statistic.add(4L, true);
        statistic.add(5L, true);
        statistic.add(6L, false);

        assertThat(statistic.getHitThree()).isEqualTo(2);
        assertThat(statistic.getHitFour()).isEqualTo(1);
        assertThat(statistic.getHitFiveWithBonus()).isEqualTo(1);
        assertThat(statistic.getHitSix()).isEqualTo(1);
    }
}