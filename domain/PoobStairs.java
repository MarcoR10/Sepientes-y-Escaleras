package domain;
import java.awt.*;
import javax.swing.*;

public class PoobStairs {
    private int Pos1,Pos2;
    private Token J1,J2;
    private Board Tablero;
    private Dice Dado = new Dice(6);

    public PoobStairs() {
        Pos1 = 0;
        Tablero = new Board(10,10);
        MontarFichas(Tablero);
    }

    public void MontarFichas(Board Tablero){
        CBox Casilla = Tablero.getCasillas(0,9);
        J1 = new Token(Casilla,Color.white) ;
        Tablero.colocarFicha(0,9,J1);
    }

}