package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            int index = this.findBy(source); // определяем есть ли в клетке cell фигура
            if (index != -1) { // если есть фигура из figures то весь код ниже
                Cell[] steps = this.figures[index].way(source, dest); // для фигуры на клетке cell . получить массив клеток пути
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) { //если массив не пустой и последний элемент равен точке назначения
                    for (int i = 0; i < steps.length; i++) {
                        if (this.findBy(steps[i]) != -1) { // если на любой клетке по пути есть фигура
                            rst = false;
                            throw new Exception();
                        }
                        rst = true;
                    }
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка! На пути фигуры есть другая фигура! " + e.toString());
            return rst;
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
