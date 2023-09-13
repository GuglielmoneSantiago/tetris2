package com.ucp.Objetos.piezas;

public class PieceDogRight extends PieceBase {
    public PieceDogRight(){
        lado= (int)(Math.random()*1);
        lados();
    }
    @Override
    public void rotateLeft(){
        lado= lado-1;
        if (lado<0){
            lado=1;
        }
        lados();
    }

    @Override
    public void rotateRight(){
        lado= lado+1;
        if (lado>1){
            lado=0;
        }
        lados();
    }
    
    @Override
    public void lados(){
        reset();
        switch(lado){
            case 0:
                setValor1Matriz(2, 0);
                setValor1Matriz(2, 1);
                setValor1Matriz(1, 1);
                setValor1Matriz(1, 2);
                altura=2;
                break;
            case 1:
                setValor1Matriz(0, 0);
                setValor1Matriz(1, 0);
                setValor1Matriz(1, 1);
                setValor1Matriz(2, 1);
                altura=2;
                break;
        }
    }

    
}