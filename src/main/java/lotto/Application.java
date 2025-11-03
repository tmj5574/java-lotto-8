package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input(output);
        int purchaseAmount = input.getPurchaseAmount();
        List<Lotto> purchaseLottos = LottoService.buyLottos(purchaseAmount);
        output.printLottoNumbers(purchaseLottos);

        List<Integer> userLottoNumbers = input.getUserLottoNumbers();
        int bonusNumber = input.getBonusNumber(userLottoNumbers);
        Lotto winningLotto = new Lotto(userLottoNumbers);
        Map<Rank, Integer> statisticsMap = LottoService.calculateStatistics(purchaseLottos, winningLotto, bonusNumber);
        double profitRate = LottoService.calculateProfitRate(statisticsMap, purchaseAmount);
        output.printStatistics(statisticsMap, profitRate);
     }
}
