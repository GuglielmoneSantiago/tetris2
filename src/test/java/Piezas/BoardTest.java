package Piezas;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ucp.Objetos.piezas.*;
public class BoardTest {
    @Test
    public void test_InsertarFichas100(){
        Board b=new Board();
        for(int i=0;i<100;i++){
            b.generarFichaAleatoria();
        }
        long result=b.lista.stream().filter(ficha->ficha.getClass().getSimpleName()=="PieceStick").count();
        if(result>0){
            assertNotNull(result);
            return;
        }
    }
    @Test
    public void actualizarBoard0_Test(){
        Board b=new Board();
        PieceDogLeft p= new PieceDogLeft();
        p.establecerPosicion(0,0);
        b.piezaActiva=p;
        b.actualizarBoard0();
        assertEquals(0,b.getValor(0,0));
    }
    @Test
    public void setName_getName_board_Test(){
        Board b=new Board();
        b.setName("tablero");
        assertEquals("tablero",b.getName());
    }
    
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
    public void Borrar_FilaLlena_TrueTest(){
        Board b=new Board();
        for(int x=0;x<5;x++){
            PieceSquare s=new PieceSquare();
            b.piezaActiva=s;
            b.piezaActiva.establecerPosicion(x*2, 0);
            for(int y=0;y<20;y++){
                b.bajarFicha();
            }
        }
        PieceSquare s=new PieceSquare();
        b.piezaActiva=s;
        b.piezaActiva.completarParedDerecha();
        b.piezaActiva.establecerPosicion(9, 0);
        for(int y=0;y<20;y++){
            b.bajarFicha();
        }
        assertEquals(1, b.getValor(19, 0));
        b.borrarFilaLlena();
        assertEquals(0, b.getValor(19, 0));
    }
    @Test
    public void funcion_generarFichaAleatoria_notNullTest(){
        Board b=new Board();
        b.generarFichaAleatoria();
        assertNotNull(b.piezaActiva);
    }
    @Test
    public void funcion_InsertarFicha_TrueTest(){
        Board b=new Board();
        for(int i=0;i<100;i++){
        b.generarFichaAleatoria();
        b.insertarPieza();
        int posx=0;
        int posy=0;
        for(int x=0;x<10;x++){
            for(int y=0;y<2;y++){
                if(b.matriz[y][x]==1){
                    posx=x;
                    posy=y;
                }
            }
        }
        assertEquals(1,b.getValor(posy,posx));}
    }
    @Test
    public void funcion_rotarIzquierda_meterFicha(){
        Board b=new Board();
        PieceStick p=new PieceStick();
        b.piezaActiva=p;
        p.setLado(1);
        p.lados();
        b.piezaActiva.establecerPosicion(0,0);
        b.posicion1();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(2,1));
        assertEquals( 1, p.getValorMatriz(3,1));
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(2,1));
        assertEquals( 1, p.getValorPosicion(3,1));
        b.rotateLeft();
        //ficha
        assertEquals( 1, p.getValorMatriz(1,0));
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
        PieceSquare p=new PieceSquare();
        b.piezaActiva=p;
        p.setLado(0);
        p.lados();
        b.piezaActiva.establecerPosicion(0,0);
        b.posicion1();
        assertEquals( 1, p.getValorMatriz(0,1));
        assertEquals( 1, p.getValorMatriz(0,0));
        assertEquals( 1, p.getValorMatriz(1,1));
        assertEquals( 1, p.getValorMatriz(1,0));
        assertEquals( 1, p.getValorPosicion(0,1));
        assertEquals( 1, p.getValorPosicion(0,0));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(1,0));
        b.rotateRight();
        //ficha
        assertEquals( 1, p.getValorPosicion(0,1));
        assertEquals( 1, p.getValorPosicion(0,0));
        assertEquals( 1, p.getValorPosicion(1,1));
        assertEquals( 1, p.getValorPosicion(1,0));
        //tablero
        assertEquals( 1, b.getValor(0,0));
        assertEquals( 1, b.getValor(0,1));
        assertEquals( 1, b.getValor(1,1));
        assertEquals( 1, b.getValor(1,0));
         
    }
    @Test
    public void funcion_bajarFich(){
        Board board=new Board();
        PieceStick piece=new PieceStick();
        piece.setLado(0);
        piece.lados();
        board.piezaActiva=piece;
        board.piezaActiva.completarParedIzquierda();
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
