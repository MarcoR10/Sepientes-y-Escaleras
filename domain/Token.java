package domain;

import java.awt.*;

public class Token {
    private Color color;
    private CBox Casilla;
    public Token(CBox Casilla,Color color){
        this.Casilla =Casilla;
        this.color = color;
        Casilla.setFicha(this);
    }
    private void move(CBox Destino){
        Casilla.nullFicha();
        Casilla = Destino;
        Casilla.setFicha(this);
    }

}
