/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.pkg1.vareika.golpe.partida;

import java.io.File;
import java.util.*;

/**
 *
 * @author GuillermoGolpe FedericoVareika
 */
public class Partida {
    private Tablero tablero;
    private ArrayList<int[]> solucion;
    private ArrayList<int[]> movimientos;
    
    public Partida(String modo) {
        this.solucion = new ArrayList<>();
        this.movimientos = new ArrayList<>();

        this.tablero = switch (modo.toLowerCase()) {
            case "a" -> cargarDeTxt("datos.txt");
            case "b" -> cargarDeTxt("predefinido.txt");
            default -> null;
        };
    }

    private Tablero cargarDeTxt(String txt) { 
        File file = new File(txt);
        Scanner txtScanner = null;

        try {
            txtScanner = new Scanner(file);
        } catch (Exception e) {
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

    // Generar nuevo tablero valido
    public void casoC(int n, int m, int dif) {
        Random random = new Random();

        this.tablero = new Tablero(n, m);
        Tablero tableroAux;
        this.tablero.randomizarTablero();
        int i = 0;
        while(i < dif) {
            int f = random.nextInt(n);
            int c = random.nextInt(m);
            tableroAux = aplicarMovimientoAlTablero(this.tablero, f, c);
            if (!tableroAux.resuelto()) {
                this.tablero = tableroAux;
                this.solucion.add(new int[] {f+1, c+1});
                i++;
            }
        }
    }

    public ArrayList<int[]> getMovimientos() {
        return this.movimientos;
    }

    public Tablero getTablero() {
        return (Tablero) this.tablero.clone();
    }

    private Tablero aplicarMovimientoAlTablero(Tablero tablero, int f, int c) {
        Tablero nuevoTablero = (Tablero) tablero.clone();
        nuevoTablero.realizarMov(f, c);
        return nuevoTablero;
    }

    public String realizarMovimiento(int f, int c) {
        //input para posicion [0][0] = (1, 1)
        boolean retrocedido = false;
        if (f == -1 && c == -1) {
            retroceder();
            retrocedido = true;
        } else {
            this.tablero.realizarMov(f - 1, c - 1);
            this.movimientos.add(new int[]{f, c});
        }
        return retrocedido ? "retrocedido" : "movimiento realizado";
    }

    private void retroceder() {
        int movSize = this.movimientos.size();
        int[] movimiento = this.movimientos.get(movSize-1);
        this.movimientos.remove(movSize-1);
        this.tablero.realizarMov(movimiento[0] - 1, movimiento[1] - 1);
    }

    public ArrayList<int[]> generarSolucion() {
        ArrayList<int[]> solucionGenerada = new ArrayList<>();
        solucionGenerada.addAll(this.solucion);
        solucionGenerada.addAll(this.movimientos);
        quitarPares(solucionGenerada);
        return solucionGenerada;
    }

    private void quitarPares(ArrayList<int[]> lista) {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (Arrays.equals(lista.get(i), lista.get(j))) {
                    lista.remove(lista.get(i));
                    lista.remove(lista.get(j - 1));
                    j = lista.size();
                    i--;
                }
            }
        }
    }
}
