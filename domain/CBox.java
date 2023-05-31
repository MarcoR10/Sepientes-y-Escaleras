package Domain;

import java.awt.*;
import java.util.ArrayList;

public class CBox {
    private boolean hasSnake, hasLadder;
    private ArrayList<Token> fichasEnCasilla;
    private int numero, posX, posY, casillaEndItem;

    public CBox(int n){
        this.numero = n;
        fichasEnCasilla = new ArrayList<>();

    }

    public void assignPositions(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public void setItem(boolean hasASnake, int casillaFin) {

        this.hasSnake = hasASnake;
        if(hasASnake){
            setHasLadder(false);
        }
        else{
            setHasLadder(true);
        }
        this.casillaEndItem = casillaFin;
    }
    public ArrayList<Token> getFichasEnCasilla() {
        return fichasEnCasilla;
    }
    public Token getFichaEnTurno(Color color){
        Token toReturn = null;
         for(Token token : fichasEnCasilla){
             if(token.getColor().equals(color)){
                 toReturn = token;
             }
         }
        return toReturn;
    }

    public void addFicha(Token toAdd){
        fichasEnCasilla.add(toAdd);
    }
    public void setHasLadder(boolean hasALadder) {
        this.hasLadder = hasALadder;
    }
    public void removeFicha(Token toRemove){
        fichasEnCasilla.remove(toRemove);
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getNumero() {
        return numero;
    }

}
