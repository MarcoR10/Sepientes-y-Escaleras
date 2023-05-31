package Domain;

import java.awt.*;

public class Token {
    private Color color;
    private int casilla, posX, posY;
    private boolean throughSnake, throughLadder, throughSpecial;
    private String typeSpecial;

    public Token(Color color){
        casilla = 1;
        this.color = color;
        this.posX = Board.getSIZE()-1;
        this.posY = 0;
    }

    public void setCasilla(int newCasilla) {
        this.casilla = newCasilla;
    }

    public int getCasilla() {
        return casilla;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }
    public void wentThroughSnake(boolean value){
        this.throughSnake = value;
    }
    public void wentThroughLadder(boolean value){
        this.throughLadder = value;
    }
    public void wentThroughSpecial(String type){
        this.typeSpecial = type;
        if(type == null){
            throughSpecial = false;
        }
        else{
            throughSpecial = true;
        }
    }

}
