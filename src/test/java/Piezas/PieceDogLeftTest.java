package Piezas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;

public class PieceDogLeftTest {
    @Test
    public void Crear_PiezaDog(){
        PieceDogLeft p=new PieceDogLeft();
        p.setLado(0);
        p.lados();
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(2,2)); 
    }
    @Test
    public void insertar_FichaEnPosicion(){
        PieceDogLeft p=new PieceDogLeft();
        p.setLado(0);
        p.lados();
        p.resetPosicion();
        p.establecerPosicion(0, 0);
        assertEquals( 1, p.getValorPosicion(1,0));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(2,2)); 
    }

    @Test
    public void funcion_completarParedDerecha(){
        PieceDogLeft p=new PieceDogLeft();
        p.setLado(0);
        p.completarParedDerecha();
        assertEquals( 2, p.getValorMatriz(0,3));
        assertEquals( 2, p.getValorMatriz(1,3));
        assertEquals( 2, p.getValorMatriz(2,3));
        assertEquals( 2, p.getValorMatriz(3,3));
    }
    @Test
    public void funcion_rotarIzquierda(){
        PieceDogLeft p=new PieceDogLeft();
        p.setLado(0);
        p.rotateLeft();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(2,0));
    }
    @Test
    public void funcion_rotarDerecha(){
        PieceDogLeft p=new PieceDogLeft();
        p.setLado(0);
        p.rotateRight();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorMatriz(2,0));
    }
}
    