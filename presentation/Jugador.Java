package presentation;

import javax.swing.*;
import java.awt.*;

public class Jugador extends JFrame {
    public static Color colorToken;
    public static int stairswalked;
    public static int snakesTraveled;
    public static int checkboxesSpecialEnabled;
    public static int modifiersInValues;
    public static int maximaCasilla;

    public Jugador(Color colorFicha) {
        Jugador.colorToken = colorFicha;
        stairswalked = 0;
        snakesTraveled = 0;
        checkboxesSpecialEnabled = 0;
        modifiersInValues = 0;
        maximaCasilla = 0;
    }

    public Color getColorFicha() {
        return colorToken;
    }

    public int getEscalerasRecorridas() {
        return stairswalked;
    }

    public int getSerpientesRecorridas() {
        return snakesTraveled;
    }

    public int getCasillasEspecialesActivadas() {
        return checkboxesSpecialEnabled;
    }

    public int getModificadoresEnValores() {
        return modifiersInValues;
    }

    public int getMaximaCasilla() {
        return maximaCasilla;
    }

    public void setEscalerasRecorridas(int escalerasRecorridas) {
        this.stairswalked = escalerasRecorridas;
    }

    public void setSerpientesRecorridas(int serpientesRecorridas) {
        this.snakesTraveled = serpientesRecorridas;
    }

    public void setCasillasEspecialesActivadas(int casillasEspecialesActivadas) {
        this.checkboxesSpecialEnabled = casillasEspecialesActivadas;
    }

    public void setModificadoresEnValores(int modificadoresEnValores) {
        this.modifiersInValues = modificadoresEnValores;
    }

    public void setMaximaCasilla(int maximaCasilla) {
        this.maximaCasilla = maximaCasilla;
    }
}
