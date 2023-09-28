/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;

import java.util.ArrayList;

/**
 *
 * @author guillermogolpe
 */
public class Partida {
    private ArrayList<Tablero> tableros;
    private ArrayList<int[]> solucion;
    private ArrayList<int[]> movimientos;
    
    public Partida(String modo) {
        this.tableros = new ArrayList<>();
        this.solucion = new ArrayList<>();
        this.movimientos = new ArrayList<>();

        switch (modo) {
            case "A":
                casoA();
                break;
            case "B":
                casoB();
                break;
        }
    }
    
    public void setTableros(ArrayList<Tablero> tableros) {
        this.tableros = tableros;
    }
    
    // Cargar tablero de datos.txt
    public void casoA() {
        
    }
    
    // Cargar tablero predefinido
    public void casoB() {
        
    }
    
    // Generar nuevo tablero valido
    public void casoC(int n, int m, int dif) {
        
    }
}
