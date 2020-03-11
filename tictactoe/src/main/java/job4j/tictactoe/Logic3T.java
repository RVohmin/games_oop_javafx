package job4j.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWin(Predicate<Figure3T> condition) {
        if (this.fillBy(condition, 0, 0, 1, 1) ||
                this.fillBy(condition, this.table.length - 1, 0, -1, 1)) {
            return true;
        }
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(condition, 0, i, 1, 0) ||
                    this.fillBy(condition, i, 0, 0, 1)
            ) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table).flatMap(Arrays::stream).anyMatch(e -> !e.hasMarkX() && !e.hasMarkO());
    }
}
