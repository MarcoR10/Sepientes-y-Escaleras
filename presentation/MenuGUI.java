package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class MenuGUI extends JFrame {
    private static MenuGUI snakesInterface;
    private JPanel Inicio;
    private JLabel Front;
    private JButton BJugar;
    private Dimension Pantalla;
    private JMenu archivo, settings;
    private JMenuBar menuBar;
    private JMenuItem load, save, start, quit, tamano, colorselect;
    private BoardGUI boardGUI;
    private Configuracion2 gameConfig;
    private Configuracion configuracion;
    private Color colorFondo;
    private JFileChooser fileChooser;
    private ImageIcon Fondo;


    //-------------------------------------------------------------------------//
    public MenuGUI() {
        prepareElements();
        prepareActions();
    }
    //-------------------------------------------------------------------------//
    public static MenuGUI getGUI() {
        if (snakesInterface == null) {
            snakesInterface = new MenuGUI();
        }
        return snakesInterface;
    }

    //-------------------------------------------------------------------------//
    public void prepareElements() {
        setTitle("PoobStairs");
        Pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(Pantalla.width/2, Pantalla.height/2);
        setLocationRelativeTo(null);
        PanelInicial();
    }
    //-------------------------------------------------------------------------//
    private void PanelInicial() {
        //--------------------------------------------//
        Inicio = new JPanel();
        Inicio.setLayout(null);
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
        Image Fon = Fondo.getImage().getScaledInstance(Pantalla.width/2,Pantalla.height/2 ,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Front = new JLabel(Fone);
        Front.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        //--------------------------------------------//
        BJugar = new JButton("Play");
        BJugar.setBackground(Color.WHITE);
        BJugar.setBounds((Pantalla.width / 5)+20,Pantalla.height / 5,150,30);
        //--------------------------------------------//
        Inicio.add(BJugar);
        Inicio.add(Front);
        add(Inicio);
    }
    //-------------------------------------------------------------------------//

    public void prepareElementsMenu() {
        colorFondo = Color.WHITE;
        setBackground(colorFondo);
        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        menuBar.add(archivo);
        settings = new JMenu("Configuración");
        menuBar.add(settings);
        start = new JMenuItem("Nuevo");
        save = new JMenuItem("Salvar");
        load = new JMenuItem("Abrir");
        quit = new JMenuItem("Salir");
        tamano = new JMenuItem("Tamaño");
        colorselect = new JMenuItem("Color");
        archivo.add(start);
        archivo.add(load);
        archivo.add(save);
        archivo.add(quit);
        settings.add(tamano);
        settings.add(colorselect);
        setJMenuBar(menuBar);
    }

    public void prepareElementsPlayerConfig2P(){
        String[] options ={"CPU", "Player", "Cancelar"};
        var selection = JOptionPane.showOptionDialog(null, "Selecciona el modo de juego:", "Advertencia",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (selection ==JOptionPane.YES_OPTION){
            Inicio.setVisible(false);
            add(configuracion = new Configuracion(1));
            validate();
            repaint();
        }
        else if (selection == JOptionPane.NO_OPTION) {
            Inicio.setVisible(false);
            add(configuracion = new Configuracion(2));
            validate();
            repaint();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    public void prepareElementsGameConfig(HashMap<String, Color> jugadores){
        this.remove(configuracion);
        add(gameConfig = new Configuracion2(jugadores));
        validate();
        repaint();
    }
    public void prepareElementsBoard(int nSerpientes, int nEscaleras, boolean hasEspeciales, int porcCasilla, int porcModif, HashMap<String, Color> jugadores) {
        this.remove(gameConfig);
        boardGUI = new BoardGUI(nSerpientes, nEscaleras, hasEspeciales, porcCasilla, porcModif, jugadores);
        add(boardGUI);
        validate();
        repaint();
    }

    public void restartGame(){
        this.remove(boardGUI);
        validate();
        repaint();
    }
    public void finishGame() {
        System.exit(0);
    }
    private void salida() {
        if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere salir", "Salir del sistema", JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }
    //-------------------------------------------------------------------------//
    public void prepareActions() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                salida();
            }
        });
        BJugar.addActionListener(e -> {
            prepareElementsPlayerConfig2P();
        });
    }
    //-------------------------------------------------------------------------//
    public void paint(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("/Imagenes/Fondo.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }
    //-------------------------------------------------------------------------//
    public static void main(String[] Args){
        snakesInterface = new MenuGUI();
        snakesInterface.setVisible(true);
    }
    //-------------------------------------------------------------------------//
}
