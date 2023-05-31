package Presentation;

import Domain.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Configuracion extends JPanel{
    private Color color;
    private String name;
    private Dimension Pantalla;
    private int nJugadores, cont;
    private HashMap<String, Color> jugadores;
    private JTextField nombreJugador;
    private JLabel nombreJText, colorJugador, title;
    private JPanel Entrada, botones;
    private JButton confirm, reset, returnToMenu, exit, colorPlayer;


    //-------------------------------------------------------------------------//
    public Configuracion(int x) {
        nJugadores = x;
        cont = 0;
        jugadores = new HashMap<>();
        prepareElements();

    }
    //-------------------------------------------------------------------------//
    public void prepareElements(){
        preparePlayerSelect();
        prepareActionsPlayerSelect();

    }
    //-------------------------------------------------------------------------//
    public void preparePlayerSelect(){
        //-------------------------------------------------------------------------//
        setLayout(new BorderLayout());
        Entrada = new JPanel();
        Entrada.setSize(new Dimension(300, 300));
        Entrada.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        nombreJText = new JLabel("Introduce tu nombre");
        nombreJText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        nombreJText.setForeground(Color.white);
        c. insets = new Insets(0,100,0,0);
        c.weighty = 4;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        //-------------------------------------------------------------------------//
        Entrada.add(nombreJText, c);
        nombreJugador = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 0;
        //-------------------------------------------------------------------------//
        Entrada.add(nombreJugador, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 0;
        c.gridy = 4;
        //-------------------------------------------------------------------------//
        colorJugador = new JLabel("Color de la Ficha");
        colorJugador.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        colorJugador.setForeground(Color.white);
        Entrada.add(colorJugador, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 4;
        //-------------------------------------------------------------------------//
        colorPlayer = new JButton("Selecciona tu color");
        Entrada.add(colorPlayer, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 0;
        c.gridy = 8;
        //-------------------------------------------------------------------------//
        confirm = new JButton("Confirmar");
        confirm.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        Entrada.add(confirm, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 8;
        //-------------------------------------------------------------------------//
        reset = new JButton("Reestablecer");
        reset.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        Entrada.add(reset, c);
        exit = new JButton("Salida");
        Entrada.setBackground(new Color(115,17,17));
        add(Entrada, BorderLayout.CENTER);
        botones = new JPanel();
        botones.setLayout(new GridLayout(1,2, 10,10));
        botones.add(exit);
        add(botones, BorderLayout.SOUTH);
    }


    //-------------------------------------------------------------------------////-------------------------------------------------------------------------//
    public void prepareActionsPlayerSelect(){
        colorPlayer.addActionListener(e -> color = JColorChooser.showDialog(null, "Escoge el color de tu ficha", null));
        confirm.addActionListener(e -> {
            try {
                setItem();
            } catch (PoobStairsException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Oops", JOptionPane.WARNING_MESSAGE);
                reset();
            }

        });
        reset.addActionListener(e -> reset());
        exit.addActionListener(e -> salida());
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    private  void setItem() throws PoobStairsException {
        if (nombreJugador.getText().equals("") || color == null){
            throw new PoobStairsException(PoobStairsException.SKIP_INFORMATION);
        }
        if (jugadores.containsKey(nombreJugador.getText()) || jugadores.containsValue(color)){
            throw new PoobStairsException(PoobStairsException.SAMECOLOR_SAMENAME);
        }
        jugadores.put(nombreJugador.getText(), color);
        cont +=1;
        if(nJugadores == 1){
            Random rand = new Random();
            jugadores.put("Máquina", new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
        }
        reset();
        validate();
    }

    public void validate(){
        System.out.println(jugadores.size());
        if(jugadores.size() == 2) {
            prepareElementsGameConfig(jugadores);
        }
        else{
            JOptionPane.showMessageDialog(null, "Jugador " + (cont + 1) + ", configura tu partida");
        }
    }
    public void reset(){
        nombreJugador.setText("");
        color = null;
    }
    public void salida(){
        System.exit(0);
    }
    public void prepareElementsGameConfig(HashMap<String, Color> jugadores){
        MenuGUI.getGUI().prepareElementsGameConfig(jugadores);
    }
    @Override
    protected void paintComponent(Graphics g){
        ImageIcon imageIcon = new ImageIcon("/Imagenes/Fondo.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, this);
        super.paintComponent(g);
    }
}
