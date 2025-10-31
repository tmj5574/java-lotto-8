package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        Output output = new Output();
        Input input = new Input(validator, output);
        int amount = input.getPurchaseAmount();
        List<Lotto> purchaseLottos = LottoService.buyLottos(amount);
     }
}
