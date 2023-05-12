package domain;

import javax.swing.*;

public class Board {
    private CBox[][] Casillas;
    private Token Ficha1,Ficha2;

    public Board(int NumRow,int NumCol){
        for (int row = 0; row < NumRow; row++) {
            for (int col = 0; col < NumCol; col++) {
                Casillas = new CBox[NumRow][NumCol];
            }
        }
    }
}
