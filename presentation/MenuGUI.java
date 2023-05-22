package presentation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class MenuGUI extends JFrame {
    private JPanel Inicio,Extra,Jugadores,jugador1Panel,jugador2Panel;
    private JLabel Front,Back,Front2, C1,C2,C3,C4, C5,J1,J1C,J2,J2C,TB;
    private JButton BJugar,BOpciones,BRegresar,BGame,confirmarButton;


    private Dimension pantalla;

    private JComboBox Modo,Maquina,Casillas,StairSnake,Modificadores,Color1,Color2;

    private JTextField Nombre1,Nombre2;
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
        C1 = new JLabel("Game mode:");
        C1.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        C1.setForeground(Color.white);
        C1.setBounds((pantalla.width / 4)+5,(pantalla.height/4)+25,150,30);
        Modo.setBounds((pantalla.width / 4)+150,(pantalla.height/4)+25,150,30);
        Extra.add(C1);
        Extra.add(Modo);
        //--------------------------------------------//
        Maquina =new JComboBox<>();
        Maquina.addItem("Beginner");
        Maquina.addItem("Trainee");
        C2 = new JLabel("Level Machine:");
        C2.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        C2.setForeground(Color.white);
        C2.setBounds((pantalla.width / 3)-175,(pantalla.height/4)+65,150,30);
        Maquina.setBounds((pantalla.width / 3)-20,(pantalla.height/4)+65,150,30);
        C2.setVisible(false);
        Maquina.setVisible(false);
        Extra.add(C2);
        Extra.add(Maquina);
        //--------------------------------------------//
        Casillas =new JComboBox<>();
        Casillas.addItem("Activated");
        Casillas.addItem("Disable");
        C3 = new JLabel("Special Box:");
        C3.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        C3.setForeground(Color.BLACK);
        C3.setBounds((pantalla.width / 3)-160,pantalla.height/7,150,30);
        Casillas.setBounds(pantalla.width / 3,pantalla.height/7,150,30);
        Extra.add(C3);
        Extra.add(Casillas);
        //--------------------------------------------//
        StairSnake =new JComboBox<>();
        StairSnake.addItem("Activated");
        StairSnake.addItem("Disable");
        C4 = new JLabel("Modified Stair:");
        C4.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        C4.setForeground(Color.WHITE);
        C4.setBounds((pantalla.width / 6)-175,pantalla.height/7,150,30);
        StairSnake.setBounds(pantalla.width / 6,pantalla.height/7,150,30);
        Extra.add(C4);
        Extra.add(StairSnake);
        //--------------------------------------------//
        Modificadores =new JComboBox<>();
        Modificadores.addItem("Activated");
        Modificadores.addItem("Disable");
        C5 = new JLabel("Modifiers:");
        C5.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        C5.setForeground(Color.WHITE);
        C5.setBounds((pantalla.width / 6)-120,(pantalla.height/4)+25,150,30);
        Modificadores.setBounds(pantalla.width / 6,(pantalla.height/4)+25,150,30);
        Extra.add(C5);
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
        Image Fon = Fondo.getImage().getScaledInstance(pantalla.width / 2, pantalla.height / 2, Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Front2 = new JLabel(Fone);
        Front2.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        //--------------------------------------------//
        J1 = new JLabel("Nombre Jugador 1 : ");
        J1.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        J1.setForeground(Color.white);
        J1.setBounds(pantalla.width / 9,pantalla.height/7,200,30);
        Nombre1 = new JTextField();
        Nombre1.setBounds(pantalla.width / 9,pantalla.height/6,200,30);
        Jugadores.add(Nombre1);
        Jugadores.add(J1);
        //--------------------------------------------//

        J2 = new JLabel("Nombre Jugador 2 : ");
        J2.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        J2.setForeground(Color.black);
        J2.setBounds((pantalla.width / 3)-100,pantalla.height/7,200,30);
        Nombre2 = new JTextField();
        Nombre2.setBounds((pantalla.width /3)-100,pantalla.height/6,200,30);
        Jugadores.add(Nombre2);
        Jugadores.add(J2);
        //--------------------------------------------//
        J1C = new JLabel("Color Jugador 1 : ");
        J1C.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        J1C.setForeground(Color.white);
        J1C.setBounds(pantalla.width / 9,pantalla.height/5,200,30);
        Color1 = new JComboBox<>();
        Color1.addItem("Rojo");
        Color1.addItem("Azul");
        Color1.setBounds(pantalla.width / 9, (pantalla.height/5)+30, 100, 30);
        Jugadores.add(J1C);
        Jugadores.add(Color1);
        //--------------------------------------------//
        J2C = new JLabel("Color Jugador 2 : ");
        J2C.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        J2C.setForeground(Color.white);
        J2C.setBounds((pantalla.width / 3)-100,pantalla.height/5,200,30);
        Color2 = new JComboBox<>();
        Color2.addItem("Verde");
        Color2.addItem("Amarillo");
        Color2.setBounds((pantalla.width / 3)-100, (pantalla.height/5)+30, 100, 30);
        Jugadores.add(J2C);
        Jugadores.add(Color2);
        //--------------------------------------------//
        TB = new JLabel("Tamaño del Tablero : ");
        TB.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        TB.setForeground(Color.white);
        TB.setBounds(pantalla.width /2,pantalla.height/4,200,30);
        //--------------------------------------------//
        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(pantalla.width / 5 , (pantalla.height / 4)+200, 150, 30);
        Jugadores.add(confirmarButton);
        confirmarButton.setEnabled(false);
        //--------------------------------------------//
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

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Confirmacion();
            }
        });

        Modo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) Modo.getSelectedItem();
                if(opcion == "Player vs Machine"){
                    C2.setVisible(true);
                    Maquina.setVisible(true);
                }else{
                    C2.setVisible(false);
                    Maquina.setVisible(false);
                }
            }
        });

        Nombre1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCamposLlenos();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCamposLlenos();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCamposLlenos();
            }

        });

        Nombre2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCamposLlenos();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCamposLlenos();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCamposLlenos();
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
    private void verificarCamposLlenos() {
        boolean camposLlenos = !Nombre1.getText().isEmpty() && !Nombre2.getText().isEmpty();
        confirmarButton.setEnabled(camposLlenos);
    }
    public static void main(String[] args) {
        MenuGUI gui = new MenuGUI();
        gui.setVisible(true);
    }
}



