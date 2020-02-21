package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void methodPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Cell currentPosition = bishopBlack.position();
        assertThat(Cell.H3, is(currentPosition));
    }
    @Test
    public void methodCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Figure copyPosition = bishopBlack.copy(Cell.H3);
        assertThat(bishopBlack.position(), is(copyPosition.position()));
    }
    @Test
    public void methodWayToUpRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H3);
        Cell[] result = bishopBlack.way(Cell.H3, Cell.D7);
        Cell[] expected = {Cell.G4, Cell.F5, Cell.E6, Cell.D7};
        assertThat(result, is(expected));
    }

    @Test
    public void methodWayToDownLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D5);
        Cell[] result = bishopBlack.way(Cell.D5, Cell.H1);
        Cell[] expected = {Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(result, is(expected));
    }

    @Test
    public void methodWayToUpLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D5);
        Cell[] result = bishopBlack.way(Cell.D5, Cell.A2);
        Cell[] expected = {Cell.C4, Cell.B3, Cell.A2};
        assertThat(result, is(expected));
    }

    @Test
    public void methodWayToDownRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D5);
        Cell[] result = bishopBlack.way(Cell.D5, Cell.G8);
        Cell[] expected = {Cell.E6, Cell.F7, Cell.G8};
        assertThat(result, is(expected));
    }

    @Test
    public void methodDiagonalIfToUpRightThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        boolean result = bishopBlack.isDiagonal(Cell.H1, Cell.A8);
//        boolean expected = true;
        assertThat(result, is(true));
    }
    @Test
    public void methodDiagonalIfToUpRightThenFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H1);
        boolean result = bishopBlack.isDiagonal(Cell.H1, Cell.A7);
//        boolean expected = true;
        assertThat(result, is(false));
    }
    @Test
    public void methodDiagonalIfToUpLeftThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H8);
        boolean result = bishopBlack.isDiagonal(Cell.H8, Cell.A1);
        assertThat(result, is(true));
    }
    @Test
    public void methodDiagonalIfToDownRightThenTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        boolean result = bishopBlack.isDiagonal(Cell.A2, Cell.G8);
        assertThat(result, is(true));
    }
}
