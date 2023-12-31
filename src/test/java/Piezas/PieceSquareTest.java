package Piezas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;

public class PieceSquareTest {
    @Test
    public void Crear_PiezaSquare(){
       PieceSquare p=new PieceSquare();
       assertEquals( 1, p.getValorMatriz(0,0));
       assertEquals( 1, p.getValorMatriz(0,1));
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,0)); 
    }
    @Test
    public void insertar_FichaEnPosicion(){
        PieceSquare p=new PieceSquare();
        p.setLado(0);
        p.lados();
        p.resetPosicion();
        p.establecerPosicion(0, 0);
       assertEquals( 1, p.getValorMatriz(0,0));
       assertEquals( 1, p.getValorMatriz(0,1));
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,0)); 
    }
    @Test
     public void funcion_rotarIzquierda(){   //funcion rotar izquierda case 3
         PieceSquare p=new PieceSquare();
         p.rotateLeft();
         assertEquals( 1, p.getValorMatriz(0,0));
         assertEquals( 1, p.getValorMatriz(0,1));
         assertEquals( 1, p.getValorMatriz(1,1));
         assertEquals( 1, p.getValorMatriz(1,0));   
    
    }
    @Test
     public void funcion_rotarDerecha(){   //funcion rotar izquierda case 3
         PieceSquare p=new PieceSquare();
         p.setLado(0);
         p.rotateRight();
         assertEquals( 1, p.getValorMatriz(0,0));
         assertEquals( 1, p.getValorMatriz(0,1));
         assertEquals( 1, p.getValorMatriz(1,1));
         assertEquals( 1, p.getValorMatriz(1,0));    
    
    }
    @Test
     public void funcion_completarParedDerecha(){
         PieceSquare p=new PieceSquare();
         p.setLado(0);
         p.completarParedDerecha();
         assertEquals( 2, p.getValorMatriz(0,3));
         assertEquals( 2, p.getValorMatriz(1,3));
         assertEquals( 2, p.getValorMatriz(2,3));
         assertEquals( 2, p.getValorMatriz(3,3));
     }
 
     @Test
     public void entrar_piezaDerecha(){
        PieceSquare p= new PieceSquare();
        Board b=new Board();
        b.piezaActiva=p;
        b.piezaActiva.completarParedDerecha();
        b.piezaActiva.establecerPosicion(9,0); 
        b.posicion1();
        assertEquals(1,b.getValor(0,9));
        assertEquals(1,b.getValor(0,8));
        assertEquals(1,b.getValor(1,9));
        assertEquals(1,b.getValor(1,8)); 

    }

        @Test
    public void entrar_piezaIzquierda(){
         PieceSquare p= new PieceSquare();
        Board b=new Board();
        b.piezaActiva=p;
        b.piezaActiva.completarParedDerecha();
        b.piezaActiva.establecerPosicion(0,0); 
        b.posicion1();
        assertEquals(1,b.getValor(0,1));
        assertEquals(1,b.getValor(0,0));
        assertEquals(1,b.getValor(1,1));
        assertEquals(1,b.getValor(1,0));
   
     }


}