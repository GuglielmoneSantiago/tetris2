package Piezas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.Board;

import com.ucp.Objetos.piezas.PieceLLeft;
import com.ucp.Objetos.piezas.PieceSquare;

public class PieceLLeftTest {
     @Test
    public void Crear_PiezaLLeft(){
        PieceLLeft p=new PieceLLeft();
        p.setLado(0);
        p.lados();
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,2));
        assertEquals( 1, p.getValorMatriz(0,2));
     }

     @Test
     public void insertar_FichaEnPosicion(){
         PieceLLeft p = new PieceLLeft();
         p.setLado(0);
         p.lados();
         p.resetPosicion();
         p.establecerPosicion(0, 0);
         assertEquals( 1, p.getValorPosicion(1,0));
         assertEquals( 1, p.getValorPosicion(1,1));
         assertEquals( 1, p.getValorPosicion(1,2));
         assertEquals( 1, p.getValorPosicion(0,2)); 
     }
 
     @Test
     public void funcion_completarParedDerecha(){
         PieceLLeft p=new PieceLLeft();
         p.setLado(0);
         p.completarParedDerecha();
         assertEquals( 2, p.getValorMatriz(0,3));
         assertEquals( 2, p.getValorMatriz(1,3));
         assertEquals( 2, p.getValorMatriz(2,3));
         assertEquals( 2, p.getValorMatriz(3,3));
     }
 
     @Test
     public void funcion_rotarDerecha(){  //funcion rotar derececha case 3
         PieceLLeft p=new PieceLLeft();
         p.setLado(0);
         p.rotateRight();
         assertEquals( 1, p.getValorMatriz(0,1));
         assertEquals( 1, p.getValorMatriz(0,2));
         assertEquals( 1, p.getValorMatriz(1,2));
         assertEquals( 1, p.getValorMatriz(2,2));   
    }
   @Test
     public void funcion_rotarIzquierda(){   //funcion rotar izquierda case 1
         PieceLLeft p=new PieceLLeft();
         p.setLado(0);
         p.rotateLeft();
         assertEquals( 1, p.getValorMatriz(1,0));
         assertEquals( 1, p.getValorMatriz(2,0));
         assertEquals( 1, p.getValorMatriz(2,1));
         assertEquals( 1, p.getValorMatriz(2,2));   
    
    }
    @Test
    public void entrar_piezaDerecha(){
        PieceLLeft p= new PieceLLeft();
        Board b=new Board();
        p.setLado(0);
        p.lados();
        b.piezaActiva=p;
        
        b.piezaActiva.completarParedDerecha();
        b.piezaActiva.establecerPosicion(9,0);
        b.posicion1(); 
        assertEquals(1,b.getValor(0,9));
        assertEquals(1,b.getValor(1,9));
        assertEquals(1,b.getValor(1,8));
        assertEquals(1,b.getValor(1,7)); 
        
    }

        @Test
    public void entrar_piezaIzquierda(){
        PieceSquare p= new PieceSquare();
        Board b=new Board();
        p.setLado(0);
        p.lados();
        b.piezaActiva=p;
        b.insertarPieza();
        b.piezaActiva.setLado(1);
        b.piezaActiva.completarParedIzquierda();
        b.actualizarBoard0();
        b.piezaActiva.establecerPosicion(0, 0);
        b.actualizarBoard1();
        assertEquals(1,b.getValor(0,1));   
        assertEquals(1,b.getValor(0,1));  
        assertEquals(1,b.getValor(1,2));  
        assertEquals(1,b.getValor(1,0));
    
          
    }

}
