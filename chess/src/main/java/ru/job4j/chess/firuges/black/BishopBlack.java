package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;

    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws IllegalStateException {
        if (!isDiagonal(source, dest)) {
            try {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
            } catch (IllegalStateException e) {}
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        Integer.compare(dest.x, source.x);
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + deltaX + index * deltaX, source.y + deltaY + index * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
