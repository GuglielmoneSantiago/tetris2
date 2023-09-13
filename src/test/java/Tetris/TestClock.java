package Tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.Tetris.Tetris;
import com.ucp.Objetos.piezas.Board;
import com.ucp.Objetos.piezas.PieceSquare;

public class TestClock {
    @Test
    public void tick_test_trueTest(){
        Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p= new PieceSquare();
        board.piezaActiva=p;
        t.boardT=board;
        t.tick();
        t.clock.tick();
        assertEquals(1,t.boardT.getValor(2,1));
        assertEquals(1,t.boardT.getValor(2,0));
        assertEquals(1,t.boardT.getValor(3,1));
        assertEquals(1,t.boardT.getValor(3,0));
    }
    @Test
    public void getTiempo_test_trueTest(){
        Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p= new PieceSquare();
        board.piezaActiva=p;
        t.boardT=board;
        t.tick();
        t.clock.tick();
        assertEquals(2,t.clock.getTiempo());
    }
}
