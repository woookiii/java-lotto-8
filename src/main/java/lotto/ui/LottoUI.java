package lotto.ui;

import lotto.Lotto;

public class LottoUI {

    public void showNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void showLottoCount(Integer lottoCount) {
        System.out.format("%n%d개를 구매했습니다.%n", lottoCount);
    }
}
