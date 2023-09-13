package com.ucp.Objetos.Tetris;

import com.ucp.Objetos.piezas.Board;

public class Clock {
    Board board;
    public int tiempo=0;
    public int getTiempo(){
        return tiempo;
    }
    public void tick(){
        board.bajarFichaJuego();
        tiempo=tiempo+1;
    }
}
