package com.ucp.Objetos.piezas;

import com.ucp.Objetos.Tetris.Tetris;

public class main { public static void main(String[] args) {
    Tetris t=new Tetris();
        Board board=new Board();
        PieceSquare p= new PieceSquare();
        board.piezaActiva=p;
        t.boardT=board;
        t.tick();
    
    
    
    
    
    // Inicializa y muestra la primera pieza
    System.out.print(board.getEstado());
    System.out.print("  piezaActiva1 \n");
    board.piezaActiva.printBoard();
    System.out.print("  tablero1 \n");
    board.printBoard();
    System.out.print(board.contador);
    }
    
}
