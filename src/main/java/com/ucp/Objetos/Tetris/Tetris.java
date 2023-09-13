package com.ucp.Objetos.Tetris;

import com.ucp.Objetos.piezas.Board;

public class Tetris {
    public Board boardT=new Board();
    public Clock clock=new Clock();
    
    public void start(){     
        boardT.generarFichaAleatoria();
        boardT.insertarPieza();
    }
    public void rotateLeft(){
        if(boardT.piezaActiva!=null){
            boardT.rotateLeft();
        }
    }
    public void rotateRight(){
        if(boardT.piezaActiva!=null){
            boardT.rotateRight();;
        }
    }
    public int state(){
        return boardT.getEstado();
    }
    public void tick(){
        clock.board=boardT;
        clock.tick();
    }
}
