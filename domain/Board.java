package domain;

import javax.swing.*;

public class Board {
    public CBox[][] Casillas;
    private Token Ficha1, Ficha2;

    public Board(int NumRow, int NumCol) {
        Casillas = new CBox[NumRow][NumCol];
        for (int row = 0; row < NumRow; row++) {
            for (int col = 0; col < NumCol; col++) {
                Casillas[row][col] = new CBox(row, col);
            }
        }
    }
    public int getNumRows() {
        return Casillas.length; }
    }

    public int getNumCols() {
        if (Casillas.length > 0) {
            return Casillas[0].length; }
        }
        return 0; }
    }
    public int getCellValue(int row, int col) {
        if (row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols()) {
            return Casillas[row][col].getValue();
        } else {
            
            return -1; 
        }
    }
}
