
package obligatorio.pkg1.vareika.golpe;

import java.util.*;

import obligatorio.pkg1.vareika.golpe.partida.Partida;
import obligatorio.pkg1.vareika.golpe.partida.Tablero;

/**
 *
 * @author GuillermoGolpe FedericoVareika
 */

// TODO preguntar si las filas y columnas se ingresan por separado
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Desea jugar?");
        while (recibirRespuesta()) {
            long startTime = System.currentTimeMillis();
            Partida partida = iniciarJuego();
            PrettyPrinter.printUnTablero(partida.getTablero());

            boolean continuarJugando = true;
            while (continuarJugando) {
                System.out.println("Ingrese movimiento o X/H/S:");
                String movimiento = in.nextLine();
                continuarJugando = realizarMovimiento(partida, movimiento);
            }

            long endTime = System.currentTimeMillis();
            System.out.printf("Tiempo insumido en partida: %s segundos %n", (endTime - startTime) / 1000);
            System.out.println("Desea volver a jugar?");
        }

        System.out.println("Hasta luego!");
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
        Partida partida = null;
        String modo = in.nextLine();
        boolean flag = true;
        while (flag) {
            switch (modo.toLowerCase()) {
                case "a", "b" -> {
                    partida = new Partida(modo);
                    flag = false;
                }
                case "c" -> {
                    partida = new Partida(modo);
                    flag = false;
                    configPartida(partida);
                }
                default -> {
                    System.out.println("Ingresar respuesta valida (a/b/c):");
                    modo = in.nextLine();
                }
            }
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

                if (m >= 3 && m <= 9 &&
                        n >= 3 && n <= 9 &&
                        dif >= 1 && dif <= 8) {
                    partida.casoC(m, n, dif);
                    flag = false;
                } else {
                    System.out.println("Los datos deben de pertenecer a los rangos correctos, ingrese nuevamente:");
                }
            } catch (Exception e) {
                in.nextLine();
                System.out.println("Dato invalido, ingrese nuevamente");
            }
        }
    }

    public static boolean realizarMovimiento(Partida partida, String movimiento) {
        boolean continuarJugando = true;

        boolean respuestaValida = false;
        while (!respuestaValida) {
            respuestaValida = true;
            switch (movimiento.toLowerCase()) {
                case "s" -> PrettyPrinter.printMovimientos(partida.generarSolucion());
                case "h" -> {
                    try {
                        PrettyPrinter.printMovimientos(partida.getMovimientos());
                    } catch (Exception e) {
                        System.out.println("No has realizado ningun movimiento.");
                    }
                }
                case "x" -> {
                    continuarJugando = false;
                    System.out.println("Haz finalizado el juego.");
                }
                default -> {
                    try {
                        // separa en los casos: [f,c] [f c]
                        String[] filaColumna = movimiento.split("[ ,]");
                        int fila = Integer.parseInt(filaColumna[0]);
                        int columna = Integer.parseInt(filaColumna[1]);

                        Tablero tableroPrevio = partida.getTablero();
                        if (partida.realizarMovimiento(fila, columna).equals("retrocedido")) {
                            PrettyPrinter.printUnTablero(partida.getTablero());
                        } else {
                            PrettyPrinter.printDosTableros(
                                    tableroPrevio,
                                    partida.getTablero());
                        }
                    } catch (Exception e) {
                        respuestaValida = false;
                        System.out.println("Ingresar movimiento valido:");
                        movimiento = in.nextLine();
                    }
                }
            }
        }

        if (partida.getTablero().resuelto()) {
            continuarJugando = false;
            System.out.println("Has ganado!");
        }

        return continuarJugando;
    }
}