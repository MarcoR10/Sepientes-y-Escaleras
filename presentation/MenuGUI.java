package presentation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class MenuGUI extends JFrame {
    private JPanel Inicio,Extra,Jugadores;
    private JLabel Front,Back,Front2,text1,text2,text3,text4,text5;
    private JButton BJugar,BOpciones,BRegresar;
    private Dimension pantalla;
    private JComboBox Modo,Maquina,Casillas,StairSnake,Modificadores;
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
        panelJugadores();
        panelConfiguracion();
        panelInicial();
    }
    //-------------------------------------------------------------------------//
    private void panelInicial() {
        //--------------------------------------------//
        Inicio = new JPanel();
        Inicio.setLayout(null);
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
        Image Fon = Fondo.getImage().getScaledInstance(pantalla.width / 2,pantalla.height / 2,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Front = new JLabel(Fone);
        Front.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        //--------------------------------------------//
        BJugar = new JButton("Play");
        BJugar.setBackground(Color.WHITE);
        BJugar.setBounds((pantalla.width / 5)+20,pantalla.height / 5,150,30);
        BOpciones = new JButton("Options");
        BOpciones.setBackground(Color.WHITE);
        BOpciones.setBounds((pantalla.width / 5)+20,pantalla.height / 4,150,30);
        //--------------------------------------------//
        Inicio.add(BJugar);
        Inicio.add(BOpciones);
        Inicio.add(Front);
        add(Inicio);
    }
    private void panelConfiguracion() {
        //--------------------------------------------//
        Extra = new JPanel();
        Extra.setLayout(null);
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
        Image Fon = Fondo.getImage().getScaledInstance(pantalla.width / 2,pantalla.height / 2,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Back = new JLabel(Fone);
        Back.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        //--------------------------------------------//
        BRegresar = new JButton("Return");
        BRegresar.setBackground(Color.WHITE);
        BRegresar.setBounds((pantalla.width / 5)+20,(pantalla.height/3)+50,150,30);
        //--------------------------------------------//
        Modo =new JComboBox<>();
        Modo.addItem("Player vs Player");
        Modo.addItem("Player vs Machine");
        text1 = new JLabel("Game mode:");
        text1.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        text1.setForeground(Color.white);
        text1.setBounds((pantalla.width / 4)+5,(pantalla.height/4)+25,150,30);
        Modo.setBounds((pantalla.width / 4)+150,(pantalla.height/4)+25,150,30);
        Extra.add(text1);
        Extra.add(Modo);
        //--------------------------------------------//
        Maquina =new JComboBox<>();
        Maquina.addItem("Beginner");
        Maquina.addItem("Trainee");
        text2 = new JLabel("Level Machine:");
        text2.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        text2.setForeground(Color.white);
        text2.setBounds((pantalla.width / 3)-175,(pantalla.height/4)+65,150,30);
        Maquina.setBounds((pantalla.width / 3)-20,(pantalla.height/4)+65,150,30);
        text2.setVisible(false);
        Maquina.setVisible(false);
        Extra.add(text2);
        Extra.add(Maquina);
        //--------------------------------------------//
        Casillas =new JComboBox<>();
        Casillas.addItem("Activated");
        Casillas.addItem("Disable");
        text3 = new JLabel("Special Box:");
        text3.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        text3.setForeground(Color.BLACK);
        text3.setBounds((pantalla.width / 3)-160,pantalla.height/7,150,30);
        Casillas.setBounds(pantalla.width / 3,pantalla.height/7,150,30);
        Extra.add(text3);
        Extra.add(Casillas);
        //--------------------------------------------//
        StairSnake =new JComboBox<>();
        StairSnake.addItem("Activated");
        StairSnake.addItem("Disable");
        text4 = new JLabel("Modified Stair:");
        text4.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        text4.setForeground(Color.WHITE);
        text4.setBounds((pantalla.width / 6)-175,pantalla.height/7,150,30);
        StairSnake.setBounds(pantalla.width / 6,pantalla.height/7,150,30);
        Extra.add(text4);
        Extra.add(StairSnake);
        //--------------------------------------------//
        Modificadores =new JComboBox<>();
        Modificadores.addItem("Activated");
        Modificadores.addItem("Disable");
        text5 = new JLabel("Modifiers:");
        text5.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        text5.setForeground(Color.WHITE);
        text5.setBounds((pantalla.width / 6)-120,(pantalla.height/4)+25,150,30);
        Modificadores.setBounds(pantalla.width / 6,(pantalla.height/4)+25,150,30);
        Extra.add(text5);
        Extra.add(Modificadores);
        //--------------------------------------------//
        Extra.add(BRegresar);
        Extra.add(Back);
        add(Extra);
    }
    private void panelJugadores() {
        Jugadores = new JPanel();
        Jugadores.setLayout(null);
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.png"));
        Image Fon = Fondo.getImage().getScaledInstance(pantalla.width / 2,pantalla.height / 2,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Front2 = new JLabel(Fone);
        Front2.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        Jugadores.add(Front2);
        add(Jugadores);
    }
    public void paint(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("/Imagenes/Fondo.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }

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
        Modo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) Modo.getSelectedItem();
                if(opcion == "Player vs Machine"){
                    text2.setVisible(true);
                    Maquina.setVisible(true);
                }else{
                    text2.setVisible(false);
                    Maquina.setVisible(false);
                }
            }
        });
    }

//-------------------------------------------------------------------------//

//-------------------------------------------------------------------------//

    private void Jugar() {
        Inicio.setVisible(false);
        Jugadores.setVisible(true);
        add(Jugadores);
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
    private void Confirmacion(){
        PoobStairsGUI Juego = new PoobStairsGUI();
        this.setVisible(false);
        Juego.setVisible(true);
    }
    private void Desconfirmacion(){
        Jugadores.setVisible(false);
        Inicio.setVisible(true);
        add(Inicio);
    }

}


