package Piezas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;
public class PieceDogRightTest{

    @Test
    public void Crear_PiezaDog(){
       PieceDogRight p=new PieceDogRight();
       assertEquals( 1, p.getValorMatriz(2,0));
       assertEquals( 1, p.getValorMatriz(2,1));
       assertEquals( 1, p.getValorMatriz(1,1));
       assertEquals( 1, p.getValorMatriz(1,2)); 
    }
    @Test
    public void insertar_FichaEnPosicion(){
        PieceDogRight p=new PieceDogRight();
        p.setLado(0);
        p.lados();
        p.resetPosicion();
        p.establecerPosicion(0, 0);
        assertEquals( 1, p.getValorPosicion(2,0));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(1,2)); 
    }

    @Test
    public void funcion_completarParedDerecha(){
        PieceDogRight p=new PieceDogRight();
        p.setLado(0);
        p.completarParedDerecha();
        assertEquals( 2, p.getValorMatriz(0,3));
        assertEquals( 2, p.getValorMatriz(1,3));
        assertEquals( 2, p.getValorMatriz(2,3));
        assertEquals( 2, p.getValorMatriz(3,3));
    }
    @Test
    public void funcion_rotarDerecha(){
        PieceDogRight p=new PieceDogRight();
        p.setLado(0);
        p.rotateRight();
        assertEquals( 1, p.getValorMatriz(0,0));
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));   
}
    @Test
    public void funcion_rotarIzquierda(){
        PieceDogRight p=new PieceDogRight();
        p.setLado(0);
        p.rotateLeft();
        assertEquals( 1, p.getValorMatriz(0,0));
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));   
}
@Test
public void entrar_piezaDerecha(){
    PieceDogRight p= new PieceDogRight();
    Board b=new Board();
    p.setLado(0);
    b.piezaActiva=p;
    b.insertarPieza();
    b.piezaActiva.completarParedDerecha();
    b.posicion0();
    b.piezaActiva.establecerPosicion(9,0);
    b.posicion1(); 
    assertEquals(1,b.getValor(2,7));
    assertEquals(1,b.getValor(2,8));
    assertEquals(1,b.getValor(1,8));
    assertEquals(1,b.getValor(1,9)); 

}

    @Test
public void entrar_piezaIzquierda(){
    PieceDogRight p= new PieceDogRight();
    Board b=new Board();
    b.piezaActiva=p;
    b.insertarPieza();
    b.piezaActiva.setLado(0);
    b.piezaActiva.completarParedIzquierda();
    b.posicion0();
    b.piezaActiva.establecerPosicion(0, 0);
    b.posicion1();
    assertEquals(1,b.getValor(1,1));   
    assertEquals(1,b.getValor(1,1));  
    assertEquals(1,b.getValor(1,1));  
    assertEquals(1,b.getValor(2,1)); 

      
}








    
}