package Presentation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CBoxGUI extends JPanel {
    private ArrayList<TokenGUI> fichasEnCasilla;
    private JLabel texto;

    public CBoxGUI(){
        fichasEnCasilla = new ArrayList<>();
    }
    public void addFicha(TokenGUI toAdd){
        fichasEnCasilla.add(toAdd);
        add(toAdd);
        revalidate();
        repaint();
    }
    public void removeFicha(TokenGUI toRemove){
        fichasEnCasilla.remove(toRemove);
        remove(toRemove);
        revalidate();
        repaint();
    }
    public void setText(int n){
        texto = new JLabel(Integer.toString(n), SwingConstants.RIGHT);
        texto.setVerticalAlignment(SwingConstants.TOP);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        add(texto);
    }
    public void setColorTexto(Color color){
        texto.setForeground(color);
    }
}
