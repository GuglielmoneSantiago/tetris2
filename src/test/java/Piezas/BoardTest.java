package Piezas;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;
public class BoardTest {
    @Test
    public void creacion_board_Test(){
        Board b=new Board();
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                assertEquals(0,b.getValor(y,x));                
            }
        }
    }
    @Test
    public void funcion_generarFichaAleatoria_notNullTest(){
        Board b=new Board();
        b.generarFichaAleatoria();
        assertNotNull(b.piezaActiva);
    }
    @Test
    public void funcion_InsertarFicha_notNullTest(){
        Board b=new Board();
        b.generarFichaAleatoria();
        b.insertarPieza();
        for(int i=0;i<10;i++){
            if(b.matriz[0][i]==1){
                
            }
        }
    }
    @Test
    public void funcion_rotarIzquierda_meterFicha(){
        Board b=new Board();
        PieceStick p=new PieceStick();
        b.piezaActiva=p;
        p.setLado(1);
        p.lados();
        b.insertarPieza();
        b.piezaActiva.establecerPosicion(0,0);
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1));
        assertEquals( 1, p.getValorPosicion(0,1));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(3,1));
        b.rotateLeft();
        //ficha
        assertEquals( 1, p.getValorPosicion(1,0));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(1,2));
        assertEquals( 1, p.getValorPosicion(1,3));
        //tablero
        assertEquals( 1, b.getValor(1,0));
        assertEquals( 1, b.getValor(1,1));
        assertEquals( 1, b.getValor(1,2));
        assertEquals( 1, b.getValor(1,3));
         
    }
    @Test
    public void funcion_rotarDerecha_meterFicha(){
        Board b=new Board();
        PieceStick p=new PieceStick();
        b.piezaActiva=p;
        p.setLado(1);
        p.lados();
        b.insertarPieza();
        b.piezaActiva.establecerPosicion(0,0);
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1));
        assertEquals( 1, p.getValorPosicion(0,1));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(3,1));
        b.rotateRight();
        //ficha
        assertEquals( 1, p.getValorPosicion(1,0));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(1,2));
        assertEquals( 1, p.getValorPosicion(1,3));
        //tablero
        assertEquals( 1, b.getValor(1,0));
        assertEquals( 1, b.getValor(1,1));
        assertEquals( 1, b.getValor(1,2));
        assertEquals( 1, b.getValor(1,3));
         
    }
    @Test
    public void funcion_bajarFich(){
        Board board=new Board();
        PieceStick piece=new PieceStick();
        piece.setLado(0);
        board.piezaActiva=piece;
        piece.establecerPosicion(0, 0);
        for(int i=0;i<20;i++){
            board.bajarFicha();
        }
        assertEquals( 1, piece.getValorPosicion(19,0));
        assertEquals( 1, piece.getValorPosicion(19,1));
        assertEquals( 1, piece.getValorPosicion(19,2));
        assertEquals( 1, piece.getValorPosicion(19,3)); 
    }
}
