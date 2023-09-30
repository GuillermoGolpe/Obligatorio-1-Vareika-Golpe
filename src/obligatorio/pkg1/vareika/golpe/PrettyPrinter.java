package obligatorio.pkg1.vareika.golpe;

import obligatorio.pkg1.vareika.golpe.partida.Tablero;
import obligatorio.pkg1.vareika.golpe.partida.Celda;

public class PrettyPrinter {
    private static final char BORDER_KNOT = '+';
    private static final char HORIZONTAL_BORDER = '-';
    private static final char VERTICAL_BORDER = '|';
    private static final String HORIZONTAL_PADDING = " ";
    private static final int VERTICAL_PADDING = 1;
    private static final String ROJO = "\\u001B[31m";
    private static final String AZUL = "\\u001B[31m";
    private static final String RESET = "\\u001B[31m";

 
    public static void printUnTablero(Tablero tablero) {
        final Celda[][] celdas = tablero.getCeldas();
        System.out.println(getFilasNumero(celdas.length));
        System.out.println("   " + getHorizontalBorder(celdas.length));
        for (int i = 0; i < celdas.length; i++) {
            System.out.println(getFila(celdas[i], i+1));
        }
    }


    private static String getFilasNumero(int length) {
        StringBuilder builder = new StringBuilder(256);
        builder.append("   ");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < HORIZONTAL_PADDING.length() + 1; j++) {
                builder.append(HORIZONTAL_PADDING);
            }
            builder.append(i+1);
            builder.append(HORIZONTAL_PADDING);
        }
        return builder.toString();
    }

    private static String getHorizontalBorder(int length) {
        StringBuilder builder = new StringBuilder(256);
        builder.append(BORDER_KNOT);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 2 * HORIZONTAL_PADDING.length() + 1; j++) {
                builder.append(HORIZONTAL_BORDER);
            }
            builder.append(BORDER_KNOT);
        }
        return builder.toString();
    }

    private static String getFila(Celda[] fila, int n) {
        StringBuilder builder = new StringBuilder(256);
        builder.append(" " + n + " " + VERTICAL_BORDER);
        for (Celda celda : fila) {
            switch (celda.getColor()) {
                case 'A':
                    builder.append(AZUL);
                    break;
                case 'R':
                    builder.append(ROJO);
                    break;
            }
            builder.append(HORIZONTAL_PADDING);
            builder.append(celda.getSimbolo() + HORIZONTAL_PADDING + RESET + VERTICAL_BORDER);
        }
        return builder.toString();
    }
}