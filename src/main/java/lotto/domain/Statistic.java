package lotto.domain;

import lotto.enumeration.Prize;

public class Statistic {
    private Integer hitThree = 0;
    private Integer hitFour = 0;
    private Integer hitFiveWithoutBonus = 0;
    private Integer hitFiveWithBonus = 0;
    private Integer hitSix = 0;

    public Long calculateProfit() {
        Long profit = 0L;
        profit += (long) this.hitThree * Prize.HIT_THREE.getMoney();
        profit += (long) this.hitFour * Prize.HIT_FOUR.getMoney();
        profit += (long) this.hitFiveWithoutBonus * Prize.HIT_FIVE_WITHOUT_BONUS.getMoney();
        profit += (long) this.hitFiveWithBonus * Prize.HIT_FIVE_WITH_BONUS.getMoney();
        profit += (long) this.hitSix * Prize.HIT_SIX.getMoney();
        return profit;
    }

    public void add(Long winCount, Boolean bonus) {
        if (winCount.equals(Prize.HIT_THREE.getHits())) {
            this.hitThree++;
            return;
        }
        checkFourToSix(winCount, bonus);
    }

    private void checkFourToSix(Long winCount, Boolean bonus) {
        if (winCount.equals(Prize.HIT_FOUR.getHits())) {
            this.hitFour++;
            return;
        }
        checkFiveToSix(winCount, bonus);
    }

    private void checkFiveToSix(Long winCount, Boolean bonus) {
        if (bonus && winCount.equals(Prize.HIT_FIVE_WITH_BONUS.getHits())) {
            this.hitFiveWithBonus++;
            return;
        }
        if (winCount.equals(Prize.HIT_FIVE_WITHOUT_BONUS.getHits())) {
            this.hitFiveWithoutBonus++;
            return;
        }
        checkSix(winCount);
    }

    private void checkSix(Long winCount) {
        if (winCount.equals(Prize.HIT_SIX.getHits())) {
            this.hitSix++;
        }
    }

    public Integer getHitThree() {
        return hitThree;
    }

    public Integer getHitFour() {
        return hitFour;
    }

    public Integer getHitFiveWithoutBonus() {
        return hitFiveWithoutBonus;
    }

    public Integer getHitFiveWithBonus() {
        return hitFiveWithBonus;
    }

    public Integer getHitSix() {
        return hitSix;
    }
}
