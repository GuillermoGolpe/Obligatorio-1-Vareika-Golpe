
package obligatorio.pkg1.vareika.golpe;

import java.util.*;

import obligatorio.pkg1.vareika.golpe.partida.Partida;
import obligatorio.pkg1.vareika.golpe.partida.Tablero;

public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        System.out.println("Desea jugar?");
        boolean jugarFlag = recibirRespuesta();

        while (jugarFlag) {
            Partida partida = iniciarJuego();
            PrettyPrinter.printUnTablero(partida.getTablero());

            boolean continuarJugando = true;
            while (continuarJugando) {
                continuarJugando = realizarMovimiento(partida);
            }

            System.out.println("Desea volver a jugar?");
            jugarFlag = recibirRespuesta();
        }
    }

    public static boolean recibirRespuesta() {
        String respuesta = in.nextLine();
        while (!respuesta.equalsIgnoreCase("si")
                && !respuesta.equalsIgnoreCase("no")) {
            System.out.println("Ingresar respuesta valida (si/no)");
            respuesta = in.nextLine();
        }
        return respuesta.equalsIgnoreCase("si");
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

    //TODO fijarse q en s no se vaya para atras sin movimientos
    public static boolean realizarMovimiento(Partida partida) {
        boolean continuarJugando = true;
        System.out.println("Ingrese fila de movimiento o X/H/S:");
        String movimiento = in.nextLine();

        boolean flagMovimiento = false;
        while (!movimiento.equalsIgnoreCase("x") &&
                !movimiento.equalsIgnoreCase("h") &&
                !movimiento.equalsIgnoreCase("s") &&
                !flagMovimiento && continuarJugando) {
            try {
                int fila = Integer.parseInt(movimiento);
                System.out.println("Columna:");
                String columnaStr = in.nextLine();
                int columna = Integer.parseInt(columnaStr);

                Tablero tableroPrevio = partida.getTablero();
                continuarJugando = partida.realizarMovimiento(fila, columna);

                PrettyPrinter.printDosTableros(
                        tableroPrevio,
                        partida.getTablero());

                flagMovimiento = true;
            } catch (Exception e) {
                System.out.println("Ingresar movimiento valido");
                movimiento = in.nextLine();
            }
        }

        if (!flagMovimiento) {
            continuarJugando = partida.realizarMovimiento(movimiento);
            if (!continuarJugando) {
                System.out.println("Has finalizado el juego.");
            }
        } else if (!continuarJugando) {
            System.out.println("Has ganado!");
        }

        return continuarJugando;
    }
    
}
