package Tetris;
import static org.junit.Assert.*;

import org.junit.Test;

import com.ucp.Objetos.Tetris.Tetris;
import com.ucp.Objetos.piezas.Board;
import com.ucp.Objetos.piezas.PieceSquare;

public class TestTetris {
    @Test
    public void Test_Start(){
        Tetris t=new Tetris();
        
        t.start();
        int posx=0;
        int posy=0;
        for(int y=0;y<4;y++){
            for(int x=0;x<10;x++){
                if(t.boardT.getValor(y,x)==1){
                    posx=x;
                    posy=y;
                }
            }
        }
        t.boardT.mirarEstado();
        assertEquals(1, t.boardT.getEstado());
        assertEquals(1, t.boardT.getValor(posy, posx));
    }
    @Test
    public void rotateLeft_trueTest(){
        Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p=new PieceSquare();
        t.boardT=board;
        t.boardT.piezaActiva=p;
        t.rotateLeft();
        assertEquals( 1, board.getValor(0,0));
        assertEquals( 1, board.getValor(0,1));
        assertEquals( 1, board.getValor(1,1));
        assertEquals( 1, board.getValor(1,0));       
    }
    @Test
    public void rotateRight_trueTest(){
        Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p=new PieceSquare();
        t.boardT=board;
        t.boardT.piezaActiva=p;
        t.rotateRight();
        assertEquals( 1, board.getValor(0,0));
        assertEquals( 1, board.getValor(0,1));
        assertEquals( 1, board.getValor(1,1));
        assertEquals( 1, board.getValor(1,0));       
    }
    @Test
    public void estate_test(){
        Tetris t=new Tetris();
        Board board=new Board();
        t.boardT=board;
        assertEquals(0,t.state());
        
    } 
    @Test
    public void state0_test(){
        Tetris t=new Tetris();
        Board board=new Board();
        t.boardT=board;
        assertEquals(0,t.boardT.getEstado());
        
    } 

    @Test
    public void state1_test(){
        Tetris t=new Tetris();
        assertEquals(0,t.boardT.getEstado());
        t.start();
        assertEquals(1,t.boardT.getEstado());
    } 
    @Test
    public void state3_test(){
        Tetris t=new Tetris();
        Board board=new Board();
        t.boardT=board;
        for(int i=0;i<4;i++){
            for(int x=0;x<5;x++){
                PieceSquare s=new PieceSquare();
                t.boardT.piezaActiva=s;
                t.boardT.piezaActiva.establecerPosicion(x*2, 0);
                t.boardT.posicion1();
                for(int y=0;y<20;y++){
                    t.boardT.bajarFicha();
                }
            }
            PieceSquare s=new PieceSquare();
            t.boardT.piezaActiva=s;
            t.boardT.piezaActiva.completarParedDerecha();
            t.boardT.piezaActiva.establecerPosicion(9, 0);
            t.boardT.posicion1();
            for(int y=0;y<20;y++){
                t.boardT.bajarFicha();
            }
        }
        t.boardT.borrarFilaLlena();
        assertEquals(3,t.boardT.getEstado());
    }
    @Test
    public void state2_test(){
        Tetris t=new Tetris();
        Board board=new Board();
        t.boardT=board;
        for(int i=0;i<20;i++){
            t.boardT.generarFichaAleatoria();
            t.boardT.insertarPieza();
        }
        assertEquals(2,t.boardT.getEstado());
    }
    @Test
    public void tick_test(){
        Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p= new PieceSquare();
        board.piezaActiva=p;
        t.boardT=board;
        t.tick();
        assertEquals(1,t.boardT.getValor(2,1));
        assertEquals(1,t.boardT.getValor(2,0));
        assertEquals(1,t.boardT.getValor(1,1));
        assertEquals(1,t.boardT.getValor(1,0));
    }
}
