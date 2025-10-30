package lotto.domain;

public class Statistic {
    private Integer hitThree = 0;
    private Integer hitFour = 0;
    private Integer hitFiveWithoutBonus = 0;
    private Integer hitFiveWithBonus = 0;
    private Integer hitSix = 0;


    public void add(Long winCount, Boolean bonus) {
        if (winCount == 3) {
            this.hitThree++;
            return;
        }
        if (winCount == 4) {
            this.hitFour++;
            return;
        }
        if (bonus && winCount == 5) {
            this.hitFiveWithBonus++;
            return;
        }
        if (winCount == 5) {
            this.hitFiveWithoutBonus++;
            return;
        }
        if (winCount == 6) {
            this.hitSix++;
        }
    }
}
