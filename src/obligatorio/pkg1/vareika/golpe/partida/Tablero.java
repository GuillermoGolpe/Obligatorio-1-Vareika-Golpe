/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;


import java.util.Random;

/**
 *
 * @author guillermogolpe
 */
public class Tablero implements Cloneable {
    private Celda[][] celdas;

    public Tablero(int n, int m) {
        this.celdas = new Celda[n][m];
    }

    public Tablero(Celda[][] celdas) {
        this.celdas = celdas;
    }

    @Override
    protected Object clone() {
        Celda[][] celdas = new Celda[this.getCeldas().length][this.getCeldas()[0].length];
        for (int i = 0; i < this.getCeldas().length; i++) {
            for (int j = 0; j < this.getCeldas()[i].length; j++) {
                celdas[i][j] = (Celda) this.getCeldas()[i][j].clone();
            }
        }

        return (Object) new Tablero(celdas);
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }

    public int[] getDimensiones() {
        return new int[]{this.celdas.length, this.celdas[0].length};
    }

    public void setCelda(int m, int n, Celda celda) {
        this.celdas[m][n] = celda;
    }

    public boolean resuelto() {
        boolean flag = true;
        for (int i = 0; i < this.celdas.length && flag; i++) {
            for (int j = 0; j < this.celdas[i].length && flag; j++) {
                if (i != 0 && j != 0 && this.celdas[0][0].getColor() == this.celdas[i][j].getColor()) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    public void realizarMov(int f, int c){
        Celda celda = this.celdas[f][c];
        switch (celda.getSimbolo()) {
            case '/':
                for (int i = 0; i<this.celdas.length;i++){
                    for (int j = 0; j < this.celdas[0].length; j++) {
                        if(i+j == f+c){
                            this.celdas[i][j].invertirColor();
                        }
                    }
                }
                break;
            case '\\':
                for (int i = 0; i<this.celdas.length;i++){
                    for (int j = 0; j < this.celdas[0].length; j++) {
                        if(i-j == f-c){
                            this.celdas[i][j].invertirColor();
                        }
                    }
                }
                break;
            case '-':
                for (int i = 0; i< this.celdas[0].length; i++){
                    this.celdas[f][i].invertirColor();
                }
                break;
            case '|':
                for (int i = 0; i< this.celdas.length; i++){
                    this.celdas[i][c].invertirColor();
                }   
                break;
            default:
                break;
        }
        
    }

    public void randomizarTablero() {
        Random random = new Random();
        char color = '0';
        int colorNum = random.nextInt(2);
        switch (colorNum) {
            case 0:
               color = 'R';
               break;
            case 1:
                color = 'A';
                break;
        }
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[0].length; j++) {
                celdas[i][j] = new Celda(random.nextInt(4), color);
            }
        }
    }
}
