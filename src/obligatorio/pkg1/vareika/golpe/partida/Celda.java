/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;
 
/**
 *
 * @author guillermogolpe
 */


public class Celda {
    private char color;
    private char simbolo;

    public Celda(char simbolo, char color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public Celda(int simboloNum, char color) {
        switch (simboloNum) {
            case 0:
                this.simbolo = '-';
                break;
            case 1:
                this.simbolo = '|';
                break;
            case 2:
                this.simbolo = '/';
                break;
            case 3:
                this.simbolo = '\\';
                break;
        }
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public void invertirColor(){
        if (this.getColor()== 'A'){
            this.setColor('R');
        } else{
            this.setColor('A');
        }
    }
}
