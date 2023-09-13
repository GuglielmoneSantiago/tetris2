package com.ucp.Objetos.piezas;
public class PieceT extends PieceBase {
    public PieceT(){
        lado= (int)(Math.random()*3);
        lados();
        }
    @Override
    public void rotateLeft(){
        lado= lado-1;
        if (lado<0){
            lado=3;
        }
        lados();
    }
    @Override
    public void rotateRight(){
        lado= lado+1;
        if (lado>3){
            lado=0;
        }
        lados();
    }
    @Override
    public void lados(){
        reset();
        switch(lado){
            case 0:
                setValor1Matriz(0, 1);
                setValor1Matriz(1, 1);
                setValor1Matriz(1, 2);
                setValor1Matriz(1, 0);
                altura=1;
                break;
            case 1:
                setValor1Matriz(1, 0);
                setValor1Matriz(1, 1);
                setValor1Matriz(2, 1);
                setValor1Matriz(1, 2);
                altura=2;
                break;
            case 2:
                setValor1Matriz(0, 1);
                setValor1Matriz(1, 1);
                setValor1Matriz(2, 1);
                setValor1Matriz(1, 2);
                altura=2;
                break;  
            case 3:
                setValor1Matriz(1, 0);
                setValor1Matriz(1, 1);
                setValor1Matriz(1, 2);
                setValor1Matriz(2, 1);
                altura=2;
                break; 
        }
    }
    


 }
        

