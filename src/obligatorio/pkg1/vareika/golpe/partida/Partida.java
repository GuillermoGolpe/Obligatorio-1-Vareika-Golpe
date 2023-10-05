/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author guillermogolpe
 */
public class Partida {
    private ArrayList<Tablero> tableros;
    private ArrayList<int[]> solucion;
    private ArrayList<int[]> movimientos;
    
    public Partida(String modo) {
        this.setTableros(new ArrayList<>());
        this.setSolucion(new ArrayList<>());
        this.setMovimientos(new ArrayList<>());

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

    private Tablero cargarDeTxt(String txt) { 
        File file = new File(txt);
        Scanner txtScanner = null;

        try {
            txtScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int m = txtScanner.nextInt();
        int n = txtScanner.nextInt();
        txtScanner.nextLine();

        Tablero tablero = new Tablero(m, n);

        for (int i = 0; i < m; i++) {
            String[] fila = txtScanner.nextLine().split(" ");
            for (int j = 0; j < fila.length; j++) {
                tablero.setCelda(i, j,
                        new Celda(fila[j].charAt(0), fila[j].charAt(1)));
            }
        }

        int nivel = txtScanner.nextInt();

        for (int i = 0; i < nivel; i++) {
            txtScanner.nextLine();
            int f = txtScanner.nextInt();
            int c = txtScanner.nextInt();
            this.solucion.add(new int[]{f, c});
        }

        return tablero; 
    }
    
    // Cargar tablero de datos.txt
    private void casoA() {
        this.tableros.add(cargarDeTxt("datos.txt"));
    }
    
    // Cargar tablero predefinido
    private void casoB() {
        this.tableros.add(cargarDeTxt("predefinido.txt"));
    }
    
    // Generar nuevo tablero valido
    public void casoC(int n, int m, int dif) {
        
    }

    public ArrayList<Tablero> getTableros() {
        return tableros;
    }

    public void setSolucion(ArrayList<int[]> solucion) {
        this.solucion = solucion;
    }

    public ArrayList<int[]> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<int[]> movimientos) {
        this.movimientos = movimientos;
    }
    
    public Tablero aplicarMovimiento(int f, int c) {
        Tablero nuevoTablero = this.tableros.get(this.tableros.size() - 1);
        nuevoTablero.realizarMov(f, c);
        return nuevoTablero;
    }

}
