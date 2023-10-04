
package obligatorio.pkg1.vareika.golpe;

import java.util.*;

import obligatorio.pkg1.vareika.golpe.partida.Partida;

public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        System.out.println("Desea jugar?");
        String respuesta = in.nextLine();
        if (respuesta.equals("Si")){
            Partida partida = iniciarJuego();
            PrettyPrinter.printUnTablero(partida.getTableros().get(0));
        }

        boolean flag = true;
        while (flag) {
            pedirMovimiento();
        }

    }
    
    public static Partida iniciarJuego() {
        System.out.println("Seleccione una opcion de juego");
        String modo = in.nextLine();
        Partida partida = new Partida(modo);

        if (modo.equals("c")){
            configPartida(partida);
        }

        return partida;
    }
    
    public static void configPartida(Partida partida) {
        System.out.println("Ingrese, cantidad de filas, cantidad de columnas y dificultad");
        boolean flag = true;
        while (flag) {
            try {
                int m = in.nextInt();
                int n = in.nextInt();
                int dif = in.nextInt();
                in.nextLine();
                partida.casoC(m, n, dif);
                flag = false;
            } catch (Exception e) {
                System.out.println("Datos invalidos, ingrese nuevamente:");
            }
        }
    }
    
    public static void pedirMovimiento() {
        
    }
    
}
