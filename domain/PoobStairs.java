package domain;

import java.awt.*;
import javax.swing.*;

public class PoobStairs {
    private final Board Tablero;

    public PoobStairs() {
        String nombreJugador1 = JOptionPane.showInputDialog(null, "Ingrese el nombre del Jugador 1:");
        String nombreJugador2 = JOptionPane.showInputDialog(null, "Ingrese el nombre del Jugador 2:");

        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        String colorJugador1 = (String) JOptionPane.showInputDialog(null, "Seleccione el color del Jugador 1:",
                "Selección de color", JOptionPane.PLAIN_MESSAGE, null, colores, colores[0]);
        String colorJugador2 = (String) JOptionPane.showInputDialog(null, "Seleccione el color del Jugador 2:",
                "Selección de color", JOptionPane.PLAIN_MESSAGE, null, colores, colores[0]);

        Player jugador1 = new Player(nombreJugador1, getColorFromName(colorJugador1));
        Player jugador2 = new Player(nombreJugador2, getColorFromName(colorJugador2));

        int numRows = ingresarNumeroFilas();
        int numCols = ingresarNumeroColumnas();

        Tablero = new Board(numRows, numCols);

        JFrame ventana = new JFrame("Tablero de PoobStairs");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTablero(g);
            }
        };

        ventana.add(panel);
        ventana.setVisible(true);
    }

    private Color getColorFromName(String colorName) {
        return switch (colorName) {
            case "Rojo" -> Color.RED;
            case "Azul" -> Color.BLUE;
            case "Verde" -> Color.GREEN;
            case "Amarillo" -> Color.YELLOW;
            default -> Color.BLACK;
        };
    }

    private int ingresarNumeroFilas() {
        String input = JOptionPane.showInputDialog("Ingrese el número de filas:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 10;
        }
    }

    private int ingresarNumeroColumnas() {
        String input = JOptionPane.showInputDialog("Ingrese el número de columnas:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 10;
        }
    }

    private void dibujarTablero(Graphics g) {
        int windowWidth = g.getClipBounds().width;
        int windowHeight = g.getClipBounds().height;
        int numRows = Tablero.getNumRows();
        int numCols = Tablero.getNumCols();
        int cellWidth = windowWidth / numCols;
        int cellHeight = windowHeight / numRows;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int cellValue = Tablero.getCellValue(row, col);
                g.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                g.drawString(String.valueOf(cellValue), col * cellWidth + cellWidth / 2,
                        row * cellHeight + cellHeight / 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PoobStairs game = new PoobStairs();
        });
    }
}
