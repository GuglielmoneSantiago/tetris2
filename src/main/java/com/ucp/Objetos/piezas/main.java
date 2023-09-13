package com.ucp.Objetos.piezas;

public class main {
    public static void main(String[] args) {
    Board board=new Board();
    
    for(int x=0;x<4;x++){
        PieceSquare s=new PieceSquare();
        board.piezaActiva=s;
        board.insertarPieza();
        board.bajarFicha();
        board.piezaActiva.establecerPosicion(x*2, 0);
        for(int y=0;y<20;y++){
            board.bajarFicha();
        }

    }
    
    
    
    
    
    // Inicializa y muestra la primera pieza
    System.out.print("  piezaActiva1 \n");
    board.piezaActiva.printBoard();
    System.out.print("  tablero1 \n");
    board.printBoard();
    }
    
}
