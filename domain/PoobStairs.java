package domain;

import java.awt.*;
import javax.swing.*;

public class PoobStairs {

    private Player J1,J2;
    private Board Tablero;

    public PoobStairs() {
        Tablero = new Board(10,10);
        MontarFichas(Tablero);
    }

    public void MontarFichas(Board Tablero){
        CBox Casilla = Tablero.getCasillas(0,9);
        new Token(Casilla,Color.white) ;
    }
    public void MoverFicha(int x,int y, int fx,int fy){
        CBox origen = Tablero.getCasillas(x,y);
        CBox destino = Tablero.getCasillas(fx,fy);
        Token ficha = origen.getToken();
    }
}