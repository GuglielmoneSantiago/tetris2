package com.ucp.Objetos.piezas;

public class main { public static void main(String[] args) {
    Board board=new Board();
    PieceDogLeft p=new PieceDogLeft();
    board.piezaActiva=p;
    board.insertarPieza();
    board.piezaActiva.setLado(0);
    board.piezaActiva.completarParedIzquierda();
    board.actualizarBoard0();
    board.piezaActiva.establecerPosicion(0, 0);
    board.actualizarBoard1();

    // Inicializa y muestra la primera pieza
    System.out.print("  piezaActiva1 \n");
    board.piezaActiva.printBoard();
    System.out.print("  tablero1 \n");
    board.printBoard();
    System.out.print(board.contador);
    }
    
}
