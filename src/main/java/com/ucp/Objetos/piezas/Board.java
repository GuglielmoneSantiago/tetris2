package com.ucp.Objetos.piezas;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public int matriz[][]=new int [20][10];
    private String name ="";
    public PieceBase piezaActiva;
    public ArrayList<PieceBase> lista= new ArrayList<>();
    protected int estado=0;
    public int contador=0;
    public Board(){
        cargarMatriz_0();
    }
    public String getName(){
        return name;
    }
    public void setlineCount(){
        contador++;
    }public int getlineCount(){
        return contador;
    }
    public void setName(String x){
        name=x;
    }
    public void posicion0(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=0;
                }
            }
        }
    }
    public void posicion1(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=1;
                }
            }
        }
    }
    public void mirarEstado(){
        if(getEstado()<2){
            for(int y=0;y<20;y++){
                for(int x=0;x<10;x++){
                    if(getValor(y, x)==1){
                        setEstado(1);
                    }
                }
            }
        }
    }
    public int getEstado(){
        return estado;
    }
    public void setEstado(int x){
        estado=x;
    }
    public int getValor(int posy,int posx){
        return matriz[posy][posx];
    }
    protected void setValor1(int posy,int posx){
        matriz[posy][posx]=1;
    }
    public void cargarMatriz_0(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                matriz[y][x]=0;
            }
        }
    }
    
    public void actualizarBoard0(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=0;
                }
            }
        }
    }
    public void actualizarBoard1(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    setValor1(y,x);
                }
            }
        }
    }
    
    public boolean puedeBajar(){
        boolean opcion=true;
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(matriz[y][x]==piezaActiva.posicion[y][x]){
                    opcion=false;
                }
            }
        }
        return opcion;
    }
    public void borrarFilaLlena(){
        for (int fila = matriz.length - 1; fila >= 0; fila--) {

            boolean filaLlena = true;

            // Verifica si todos los elementos de la fila son "1"
            for (int col = 0; col < matriz[fila].length; col++) {
                if (matriz[fila][col] != 1) {
                    filaLlena = false;
                    break;
                }
            }

            // Si la fila está llena, borra la fila moviendo las filas por encima hacia abajo
            if (filaLlena) {
                for (int i = fila; i > 0; i--) {
                    // Copia la fila de arriba en la fila actual
                    System.arraycopy(matriz[i - 1], 0, matriz[i], 0, matriz[i].length);
                }

                // Establece la fila superior como una fila vacía
                Arrays.fill(matriz[0], 0);
                fila++; // Revisa la fila actual nuevamente, ya que ahora contiene las filas de arriba
                setlineCount();
                if(getlineCount()==5){
                    setEstado(3);
                }
            }
        }
    }
    public boolean puedeGirar(){
        boolean opcion=true;
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(matriz[y][x]==piezaActiva.posicion[y][x]){
                    opcion=false;
                }
            }
        }
        return opcion;
    }
    public void rotateRight(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=0;
                }
            }
        }
        piezaActiva.rotateRight();
        piezaActiva.lados();
        piezaActiva.resetPosicion();
        piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
        if(puedeGirar()==false){
            piezaActiva.rotateLeft();
            piezaActiva.resetPosicion();
            piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
        }
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=1;
                }
            }
        }
    }

    public void rotateLeft(){
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=0;
                }
            }
        }
        piezaActiva.rotateLeft();
        piezaActiva.lados();
        piezaActiva.resetPosicion();
        piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
        
        if(puedeGirar()==false){
            piezaActiva.rotateRight();
            piezaActiva.resetPosicion();
            piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
        }
        for(int y=0;y<20;y++){
            for(int x=0;x<10;x++){
                if(piezaActiva.posicion[y][x]==1){
                    matriz[y][x]=1;
                }
            }
        }
    }
    public void bajarFichaJuego(){
        bajarFicha();
        if(((piezaActiva.posicionY)+piezaActiva.altura)>=19){
            generarFichaAleatoria();
            insertarPieza();
        }
    }
    public void bajarFicha(){
        //Limpiar Donde esta el objeto
        posicion0();
        //Bajar la ficha
        //casos no llego abajo
        if(((piezaActiva.posicionY)+piezaActiva.altura)<19){
            piezaActiva.posicionY++;
            piezaActiva.resetPosicion();
            piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
            //caso tiene ficha abajo
            if(puedeBajar()==false){
                piezaActiva.posicionY--;
                piezaActiva.resetPosicion();
                piezaActiva.establecerPosicion((piezaActiva.posicionX),(piezaActiva.posicionY));
                piezaActiva.posicionY=19;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                
                //caso no tiene ficha abajo
            }else{
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
            }
        }else{
            for(int y=0;y<20;y++){
                for(int x=0;x<10;x++){
                    if(piezaActiva.posicion[y][x]==1){
                        matriz[y][x]=1;
                }
                }
            }
        }
    }
    public void generarFichaAleatoria(){ 
        int numero = (int)(Math.random()*6+1);
        switch(numero){
            case 1:
                PieceDogLeft piezaDog=new PieceDogLeft();
                piezaActiva=piezaDog;
                lista.add(piezaActiva);
                break;
            case 2:
                PieceLRight piezaL=new PieceLRight();
                piezaActiva=piezaL;
                lista.add(piezaActiva);
                break;
            case 3:
                PieceSquare piezaSquare=new PieceSquare();
                piezaActiva=piezaSquare;
                lista.add(piezaActiva);
                break;
            case 4:
                PieceStick piezaStick=new PieceStick();
                piezaActiva=piezaStick;
                lista.add(piezaActiva);
                break;
            case 5:
                PieceT piezaT=new PieceT();
                piezaActiva=piezaT;
                lista.add(piezaActiva);
                break;
            case 6:
                PieceDogRight piezaDog2=new PieceDogRight();
                piezaActiva=piezaDog2;
                lista.add(piezaActiva);
                break;

        }
    }

    public void insertarPieza(){
        int numero = (int)(Math.random()*9);
        if(getEstado()<2){
        switch(numero){
            case 0:
                piezaActiva.completarParedIzquierda();
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            setValor1(y,x);
                        }
                    }
                }
                break;
            case 1:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 2:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 3:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 4:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 5:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 6:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 7:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 8:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
            case 9:
                piezaActiva.establecerPosicion(numero,0);
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==matriz[y][x]){
                            setEstado(2);
                            return;
                        }
                    }
                }
                piezaActiva.posicionX=numero;
                piezaActiva.posicionY=0;
                piezaActiva.completarParedDerecha();
                for(int y=0;y<20;y++){
                    for(int x=0;x<10;x++){
                        if(piezaActiva.posicion[y][x]==1){
                            matriz[y][x]=1;
                        }
                    }
                }
                break;
        }
    }
    }
}

