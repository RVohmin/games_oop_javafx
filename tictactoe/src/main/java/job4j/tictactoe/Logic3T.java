package job4j.tictactoe;

import java.util.function.Predicate;

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

    public boolean isWinnerX() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0) ||
                    this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1) ||
                    this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) ||
                    this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1)
            ) {
                return true;
            }
        }
        return false;
    }
//         return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) || //вертикаль слева
//                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) || //вертикаль средняя
//                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) || //вертикаль справа
//                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) || //горизонталь сверху
//                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) || //горизонталь средняя
//                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) || //горизонталь нижняя
//                this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) || // диагональ слева верха
//                this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1); // диагональ справа сверху


    public boolean isWinnerO() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0) ||
                    this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1) ||
                    this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) ||
                    this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1)
            ) {
                return true;
            }
        }
        return false;
    }
//        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) || //вертикаль слева
//                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) || //горизонталь сверху
//                this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) || //диагональ слева сверху
//                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) || //вертикаль средняя
//                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) || //вертикаль справа
//                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) || //горизонталь средняя
//                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) || //горизонталь нижняя
//                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1); //диагональ справа сверху

    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}
