package Presentation;

import javax.swing.*;
import java.awt.*;

public class TokenGUI extends JButton {
    private int posX, posY;
    public TokenGUI(Color colorFicha, int x, int y){
        super();
        this.posX = x;
        this.posY = y;
        setBackground(colorFicha);
        setEnabled(false);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}
