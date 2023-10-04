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
        this.setCeldas(new Celda[n][m]);
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }

    // TODO Preguntar si usar get dentro de una misma clase
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
                if (this.celdas[0][0].getColor() == this.celdas[i][j].getColor()) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
