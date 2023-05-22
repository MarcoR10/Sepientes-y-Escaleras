package domain;

import java.awt.*;

public class Player {
    private String Name;
    private Color color;
    private int Stairs,Snakes,Special_Box,Modifierds,maxBox;
    private Token Ficha;

    public Player(String Name, Color color){
        this.Name = Name;
        this.color = color;
        Stairs = 0;
        Snakes = 0;
        Special_Box = 0;
        Modifierds = 0;
        maxBox = 0;
    }

    public String getName() {
        return Name;
    }
    public Color getColor() {
        return color;
    }
    public int getStairs() {
        return Stairs;
    }
    public int getSnakes() {
        return Snakes;
    }
    public int getSpecial_Box() {
        return Special_Box;
    }
    public int getModifierds() {
        return Modifierds;
    }
    public int getMaxBox() {
        return maxBox;
    }
}
