package lotto;

import java.text.NumberFormat;
import java.util.Locale;

public enum Rank {

    FIRST(6, 2_000_000_000L, "6개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(3, 5_000L, "3개 일치"),
    MISS(0, 0L, "낙첨");

    private final int matchCount;
    private final long prizeMoney;
    private final String description;

    Rank(int matchCount, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getFormattedPrizeMoney() {
        return NumberFormat.getNumberInstance(Locale.US).format(this.prizeMoney);
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
