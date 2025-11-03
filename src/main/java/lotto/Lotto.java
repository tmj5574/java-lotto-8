package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumbers(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }
    // TODO: 추가 기능 구현

    public String getLottoNumbersString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }
}
