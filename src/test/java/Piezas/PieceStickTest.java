package Piezas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;

public class PieceStickTest {
    @Test
    public void Crear_PiezaStick_pos0(){
        PieceStick p=new PieceStick();
        p.setLado(0);
        p.lados();
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,2));
        assertEquals( 1, p.getValorMatriz(1,3)); 
      
    }
    @Test
    public void Crear_PiezaStick_pos1(){
        PieceStick p=new PieceStick();
        p.setLado(1);
        p.lados();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1)); 
      
    }
    @Test
    public void insertar_FichaEnPosicion(){
        PieceStick p=new PieceStick();
        p.setLado(1);
        p.lados();
        p.resetPosicion();
        p.establecerPosicion(0, 0);
        assertEquals( 1, p.getValorPosicion(0,1));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(3,1)); 
    }
    @Test
    public void funcion_rotarDerecha(){
        PieceStick p=new PieceStick();
        p.setLado(0);
        p.rotateRight();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1));
    }
    @Test
    public void funcion_CompletarParedIzquierda(){
        PieceStick p=new PieceStick();
        p.setLado(1);
        p.lados();
        p.completarParedIzquierda();
        assertEquals( 2, p.getValorMatriz(0,0));
        assertEquals( 2, p.getValorMatriz(1,0));
        assertEquals( 2, p.getValorMatriz(2,0));
        assertEquals( 2, p.getValorMatriz(3,0));
    }
    @Test
    public void funcion_completarParedDerecha(){
        PieceStick p=new PieceStick();
        p.setLado(1);
        p.lados();
        p.completarParedDerecha();
        assertEquals( 2, p.getValorMatriz(0,2));
        assertEquals( 2, p.getValorMatriz(1,2));
        assertEquals( 2, p.getValorMatriz(2,2));
        assertEquals( 2, p.getValorMatriz(3,2));
    }
    @Test
    public void funcion_rotarIzquierda(){
        PieceStick p=new PieceStick();
        p.setLado(0);
        p.rotateLeft();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1));
    }
    @Test
    public void entrar_piezaDerecha(){
        PieceStick p= new PieceStick();
        Board b=new Board();
        p.setLado(0);
        p.lados();
        b.piezaActiva=p;
        b.piezaActiva.completarParedDerecha();
        b.piezaActiva.establecerPosicion(9,0); 
        b.posicion1();
        assertEquals(1,b.getValor(1,6));
        assertEquals(1,b.getValor(1,7));
        assertEquals(1,b.getValor(1,8));
        assertEquals(1,b.getValor(1,9));
        
    }

        @Test
    public void entrar_piezaIzquierda(){
        PieceStick p= new PieceStick();
        Board b=new Board();
        p.setLado(0);
        p.lados();
        b.piezaActiva=p;
        b.piezaActiva.establecerPosicion(0,0); 
        b.posicion1();
        assertEquals(1,b.getValor(1,0));
        assertEquals(1,b.getValor(1,1));
        assertEquals(1,b.getValor(1,2));
        assertEquals(1,b.getValor(1,3));
    }
}
