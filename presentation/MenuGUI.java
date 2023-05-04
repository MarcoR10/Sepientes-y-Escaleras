package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    private JPanel Inicio,Extra;
    private JLabel Background,Text;
    private JButton BJugar,BOpciones,BRegresar;
    private Dimension pantalla;
    private ImageIcon Fondo;

//-------------------------------------------------------------------------//
    public MenuGUI(){
        prepareElements();
        prepareActions();
    }
//-------------------------------------------------------------------------//
    private void prepareElements() {
        setTitle("PoobStairs");
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(pantalla.width / 2, pantalla.height / 2);
        setLocationRelativeTo(null);
        panelConfiguracion();
        panelInicial();
    }

//-------------------------------------------------------------------------//
    private void panelInicial() {

        Inicio = new JPanel();
        Inicio.setBackground(Color.RED);
        Background = new JLabel();
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
        Image Fon = Fondo.getImage().getScaledInstance(pantalla.width / 2,pantalla.height / 2,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Background.setIcon(Fone);
        //--------------------------------------------//
        BJugar = new JButton("Jugar");
        BJugar.setBackground(Color.WHITE);
        BOpciones = new JButton("Configuracion");
        BOpciones.setBackground(Color.WHITE);
        Inicio.add(BJugar);
        Inicio.add(BOpciones);
        //--------------------------------------------//
        Inicio.add(Background);
        this.add(Inicio);
    }

    private void panelConfiguracion() {
        Extra = new JPanel();
        BRegresar = new JButton("Regresar");
        Extra.add(BRegresar);
        this.add(Extra);
    }

//-------------------------------------------------------------------------//



//-------------------------------------------------------------------------//



//-------------------------------------------------------------------------//

    private void prepareActions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugar();
            }
        });
        BOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Opciones();
            }
        });
        BRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regresar();
            }
        });
    }

    private void Jugar() {
        PoobStairsGUI Juego = new PoobStairsGUI();
        this.setVisible(false);
        Juego.setVisible(true);
    }

    private void Opciones() {
        Inicio.setVisible(false);
        Extra.setVisible(true);
        add(Extra);
    }

    private void Regresar() {
        Extra.setVisible(false);
        Inicio.setVisible(true);
        add(Inicio);
    }
}


