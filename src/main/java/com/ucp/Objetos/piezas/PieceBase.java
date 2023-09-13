package com.ucp.Objetos.piezas;

public abstract class PieceBase implements iRotator{
    protected int lado=0;
    protected int matriz [][] = new int [4][4];
    protected int posicion[][]=new int [20][10];
    public int posicionX=0;
    public int posicionY=0;
    public int altura=3;
    public PieceBase(){
        resetPosicion();
    }
    public int getValorMatriz(int posy,int posx){
        return matriz[posy][posx];
    }
    public void setLado(int x){
        lado=x;
    }
    
    public int getValorPosicion(int posy,int posx){
        return posicion[posy][posx];
    }
    protected void setValor1Posicion(int posy,int posx){
        posicion[posy][posx]=1;
    }
    protected void setValor1Matriz(int posy,int posx){
        matriz[posy][posx]=1;
    }
    protected void setValor2Matriz(int posy,int posx){
        matriz[posy][posx]=2;
    }
    public void reset(){
        for (int y=0; y<4;y++){
            for (int x=0;x<4;x++){
                matriz[y][x]=0;
            }
        }
    }
    public void resetPosicion(){
        for (int y=0; y<20;y++){
            for (int x=0;x<10;x++){
                posicion[y][x]=5;
            }
        }
    }
    public void establecerPosicion(int posx,int posy){
        posicionX=posx;
        posicionY=posy;
        resetPosicion();
        //Verificar que no se salga
        if(posicionX>6){
            if(matriz[0][2]==2){
                switch(posicionX){
                    case 9:
                        posicionX=posicionX-1;
                        break;
                }
            }else{if(matriz[0][3]==2){
                    switch(posicionX){
                        case 8:
                            posicionX--;
                            break;
                        case 9:
                            posicionX=posicionX-2;
                            break;
                    }
                }else{
                    switch(posicionX){
                        case 7:
                            posicionX--;
                            break;
                        case 8:
                            posicionX=posicionX-2;
                            break;
                        case 9:
                            posicionX=posicionX-3;
                            break;
                    }
                }
            }
        }
        //InsertarPieza
         
        if(matriz[0][0]==2){
            for (int y=0; y<4;y++){
                for (int x=1;x<4;x++){
                    if(getValorMatriz(y,x)==1){
                        int xx=posicionX+x-1;
                        int yy=posicionY+y;
                        setValor1Posicion(yy, xx);
                    }
                }
            }
        }else{if(matriz[0][3]==2){if(matriz[0][2]==2){
            for (int y=0; y<4;y++){
                for (int x=1;x>=0;x--){
                    if(getValorMatriz(y,x)==1){
                        int xx=posicionX+x;
                        int yy=posicionY+y;
                        setValor1Posicion(yy, xx);
                    }
                }
            }}else{
            for (int y=0; y<4;y++){
                for (int x=2;x>=0;x--){
                    if(getValorMatriz(y,x)==1){
                        int xx=posicionX+x;
                        int yy=posicionY+y;
                        setValor1Posicion(yy, xx);
                    }
                }
            }}
        }else{
            for (int y=0; y<4;y++){
                for (int x=0;x<4;x++){
                    if(getValorMatriz(y,x)==1){
                        int xx=posicionX+x;
                        int yy=posicionY+y;
                        
                        setValor1Posicion(yy, xx);
                    }
                }
            }
        }
        }
    }
    public void completarParedIzquierda(){
        for(int x=0;x<4;x++){
            int marcador=0;
            for(int y=0;y<4;y++){
                if(matriz[y][x]==1){
                    marcador=1;
                }
            }
            if(marcador==0){
                for(int y=0;y<4;y++){
                    setValor2Matriz(y, x);
                }
            }
        }
    }
    public void completarParedDerecha(){
        for(int x=3;x>0;x--){
            int marcador=0;
            for(int y=0;y<4;y++){
                if(matriz[y][x]==1){
                    marcador=1;
                }
            }
            if(marcador==0){
                for(int y=0;y<4;y++){
                    setValor2Matriz(y, x);
                } 
            }
        }
    }
}