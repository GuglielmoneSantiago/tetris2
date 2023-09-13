package com.ucp.Objetos.piezas;

public class main { public static void main(String[] args) {
    Board board=new Board();
    
    for(int i=0;i<4;i++){
        for(int x=0;x<5;x++){
            PieceSquare s=new PieceSquare();
            board.piezaActiva=s;
            board.piezaActiva.establecerPosicion(x*2, 0);
            board.posicion1();
                for(int y=0;y<20;y++){
                    board.bajarFicha();
                }
        }
        PieceSquare s=new PieceSquare();
        board.piezaActiva=s;
        board.piezaActiva.completarParedDerecha();
        board.piezaActiva.establecerPosicion(9, 0);
        board.posicion1();
        for(int y=0;y<20;y++){
            board.bajarFicha();
        }
    }
    board.borrarFilaLlena();
    
    // Inicializa y muestra la primera pieza
    System.out.print(board.getEstado());
    System.out.print("  piezaActiva1 \n");
    board.piezaActiva.printBoard();
    System.out.print("  tablero1 \n");
    board.printBoard();
    System.out.print(board.contador);
    }
    
}
