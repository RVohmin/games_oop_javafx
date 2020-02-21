package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void MoveIfClearFromH3ToF5ThenTrue() {
        Logic logic = new Logic();
        Figure bishopBlack1 = new BishopBlack(Cell.H3);
        Figure bishopBlack2 = new BishopBlack(Cell.F4); //находится не на пути движения 1й фигуры

        logic.add(bishopBlack1);
        logic.add(bishopBlack2);

        Cell source = Cell.H3;
        Cell dest = Cell.F5;
        boolean rst = logic.move(source, dest);
        assertThat(rst, is(true));
    }

    @Test
    public void MoveIfNotClearFromH3ToF5ThenTrue() {
        Logic logic = new Logic();
        Figure bishopBlack1 = new BishopBlack(Cell.H3);
        Figure bishopBlack2 = new BishopBlack(Cell.G4); // на пути движения 1й фигуры

        logic.add(bishopBlack1);
        logic.add(bishopBlack2);

        Cell source = Cell.H3;
        Cell dest = Cell.F5;
        boolean rst = logic.move(source, dest);
        assertThat(rst, is(false));
    }
}
