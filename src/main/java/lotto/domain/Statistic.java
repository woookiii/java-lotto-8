package lotto.domain;

import lotto.enumeration.Prize;

public class Statistic {
    private Integer hitThree = 0;
    private Integer hitFour = 0;
    private Integer hitFiveWithoutBonus = 0;
    private Integer hitFiveWithBonus = 0;
    private Integer hitSix = 0;


    public void add(Long winCount, Boolean bonus) {
        if (winCount < Prize.HIT_THREE.getHits()){
            return;
        }
        if (winCount.equals(Prize.HIT_THREE.getHits())) {
            this.hitThree++;
            return;
        }
        if (winCount.equals(Prize.HIT_FOUR.getHits())) {
            this.hitFour++;
            return;
        }
        if (bonus && winCount.equals(Prize.HIT_FIVE_WITH_BONUS.getHits())) {
            this.hitFiveWithBonus++;
            return;
        }
        if (winCount.equals(Prize.HIT_FIVE.getHits())) {
            this.hitFiveWithoutBonus++;
            return;
        }
        if (winCount.equals(Prize.HIT_SIX.getHits())) {
            this.hitSix++;
        }
        return;
    }
}
