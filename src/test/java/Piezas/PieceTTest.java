package Piezas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;

public class PieceTTest {
    @Test
    public void Crear_PiezaT(){
       PieceT p=new PieceT();
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,2));
       assertEquals( 1, p.getValorMatriz(1,1)); 
    }
    @Test
    public void insertar_FichaEnPosicion(){
        PieceT p=new PieceT();
        p.setLado(0);
        p.lados();
        p.resetPosicion();
        p.establecerPosicion(0, 0);
       assertEquals( 1, p.getValorMatriz(0,1));
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,2));
       assertEquals( 1, p.getValorMatriz(1,0)); 
    }
    @Test
    public void funcion_completarParedDerecha(){
        PieceT p=new PieceT();
        p.setLado(0);
        p.completarParedDerecha();
        assertEquals( 2, p.getValorMatriz(0,3));
        assertEquals( 2, p.getValorMatriz(1,3));
        assertEquals( 2, p.getValorMatriz(2,3));
        assertEquals( 2, p.getValorMatriz(3,3));
    }
    @Test
    public void funcion_rotarDerecha(){
        PieceT p=new PieceT();
        p.setLado(0);
        p.rotateRight();
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(1,2));   
    }
    @Test
    public void funcion_rotarIzquierda(){
        PieceT p=new PieceT();
        p.setLado(0);
        p.rotateLeft();
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,2));
        assertEquals( 1, p.getValorMatriz(2,1));

    }
    @Test
    public void entrar_piezaDerecha(){
        PieceT p= new PieceT();
        Board b=new Board();
        b.piezaActiva=p;
        b.insertarPieza();
        b.piezaActiva.completarParedDerecha();
        b.actualizarBoard0();
        b.piezaActiva.establecerPosicion(0, 0);
        b.actualizarBoard1();
        b.piezaActiva.establecerPosicion(9,0); 
        assertEquals(1,b.getValor(1,1));
        assertEquals(1,b.getValor(1,1));
        assertEquals(1,b.getValor(1,2));
        assertEquals(1,b.getValor(1,1));

    }

        @Test
    public void entrar_piezaIzquierda(){
        PieceT p= new PieceT();
        Board b=new Board();
        b.piezaActiva=p;
        b.insertarPieza();
        b.piezaActiva.setLado(1);
        b.piezaActiva.completarParedIzquierda();
        b.actualizarBoard0();
        b.piezaActiva.establecerPosicion(0, 0);
        b.actualizarBoard1();
       /*/  assertEquals(1,b.getValor(1,0));   
        assertEquals(1,b.getValor(1,1));  
        assertEquals(1,b.getValor(2,1));  
        assertEquals(1,b.getValor(1,0)); */
  
    }

}
