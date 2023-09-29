/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;

/**
 *
 * @author guillermogolpe
 */
public class Tablero {
    private Celda[][] celdas;

    public Tablero(int n, int m) {
        this.setCeldas(new Celda[m][n]);
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }

    public int[] getDimensiones() {
        return new int[]{this.getCeldas().length, this.getCeldas()[0].length};
    }
}
