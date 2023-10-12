
package obligatorio.pkg1.vareika.golpe;

import java.util.*;

import obligatorio.pkg1.vareika.golpe.partida.Partida;

public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        System.out.println("Desea jugar?");
        String respuesta = in.nextLine();
        while (!respuesta.equalsIgnoreCase("si")
            && !respuesta.equalsIgnoreCase("no")) {
            System.out.println("Ingresar respuesta valida (si/no)");
            respuesta = in.nextLine();
        }

        if (respuesta.equalsIgnoreCase("si")){
            Partida partida = iniciarJuego();

            PrettyPrinter.printUnTablero(partida.getTableros().get(0));
        }
    }

    public static Partida iniciarJuego() {
        System.out.println("Seleccione una opcion de juego");
        String modo = in.nextLine();
        while (!modo.equalsIgnoreCase("a")
            && !modo.equalsIgnoreCase("b")
            && !modo.equalsIgnoreCase("c")) {
            System.out.println("Ingresar respuesta valida (a/b/c):");
            modo = in.nextLine();
        }
        Partida partida = new Partida(modo);

        if (modo.equals("c")){
            configPartida(partida);
        }

        return partida;
    }
    
    public static void configPartida(Partida partida) {
        System.out.println("Ingrese datos");
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Filas (1-9):");
                int m = in.nextInt();
                in.nextLine();

                System.out.println("Columnas (1-9):");
                int n = in.nextInt();
                in.nextLine();

                System.out.println("Dificultad (1-8):");
                int dif = in.nextInt();
                in.nextLine();

                partida.casoC(m, n, dif);

                if (m >= 1 && m <= 9 &&
                    n >= 1 && n <= 9 &&
                    dif >= 1 && dif <= 8) {
                    flag = false;
                } else {
                    System.out.println(
                            "Los datos deben de pertenecer a los rangos correctos, ingrese nuevamente:");
                }
            } catch (Exception e) {
                in.nextLine();
                System.out.println("Dato invalido, ingrese nuevamente");
            }
        }
    }
    
    public static void pedirMovimiento() {
        
    }
    
}
