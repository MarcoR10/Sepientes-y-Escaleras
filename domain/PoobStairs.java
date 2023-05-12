package domain;
import java.awt.*;

public class PoobStairs {
    private Board Tablero;
    private Player Jugador1,Jugador2;

    public PoobStairs(int NumRow,int NumCol){
        //Jugador1 = new Player(Name,color);
        //Jugador2 = new Player(Name,color);
        Tablero = new Board(NumRow,NumCol);
    }
}
