package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input(output);
        int amount = input.getPurchaseAmount();
        List<Lotto> purchaseLottos = LottoService.buyLottos(amount);
        output.printLottoNumbers(purchaseLottos);
     }
}
