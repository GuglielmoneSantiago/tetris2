package Tetris;
import static org.junit.Assert.*;

import org.junit.Test;

import com.ucp.Objetos.Tetris.Tetris;

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
    public void state_test(){
        Tetris t=new Tetris();
        assertEquals(0,t.boardT.getEstado());
        t.start();
        assertEquals(1,t.boardT.getEstado());
    } 
}
