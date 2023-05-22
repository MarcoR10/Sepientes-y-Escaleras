package domain;

import java.awt.*;

public class Token {
    private Color color;

    private CBox Casilla;
    private Dice Dado =new Dice(6);

    public Token(CBox Casilla,Color color){
        this.Casilla =Casilla;
        this.color = color;
        Casilla.setFicha(this);
    }
    private void move(CBox Destino){
        Casilla.nullFicha();
        int moverserse = Dado.Roll();
        Casilla = Destino;
    }

}
