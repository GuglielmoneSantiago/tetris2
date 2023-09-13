package com.ucp.Objetos.Tetris;

import com.ucp.Objetos.piezas.Board;

public class Clock {
    Board board;
    public int tiempo=0;
    public void tick(){
        board.bajarFicha();
        tiempo=tiempo+1;
    }
}
