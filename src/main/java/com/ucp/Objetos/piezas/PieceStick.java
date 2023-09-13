package com.ucp.Objetos.piezas;

public class PieceStick extends PieceBase {
    public PieceStick(){
        lado= ((int)(Math.random()*2));
        lados();
    }
    @Override
    public void rotateLeft(){
        lado= lado+1;
        if (lado>1){
            lado=0;
        }
        lados();
    }
    @Override
    public void rotateRight(){
        lado= lado-1;
        if (lado<0){
            lado=1;
        }
        lados();
    }
    @Override
    public void lados(){
    reset();
    switch(lado){
        case 0:
            setValor1Matriz(1, 0);
            setValor1Matriz(1, 1);
            setValor1Matriz(1, 2);
            setValor1Matriz(1, 3);
            altura=1;
            break;
        case 1:
            setValor1Matriz(0, 1);
            setValor1Matriz(1, 1);
            setValor1Matriz(2, 1);
            setValor1Matriz(3, 1);
            altura=3;
            break;
        }        
    }

}