package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import static presentation.PoobStairsGUI.Player.PLAYER_1;
import static presentation.PoobStairsGUI.Player.PLAYER_2;

public class PoobStairsGUI extends JFrame {
    //-------------------------------------------------Atributos-------------------------------------------------//
    private int NUM_ROWS,NUM_COLS;
    private java.awt.Color color;
    private JButton[][] buttons;
    private JMenuBar barra;
    private JMenu menu,Configuracion;
    private JMenuItem New, Open, Saved, Restart,Color, Exit,Tamaño;
    private JFileChooser Seleccion;
    private JLabel jugador1Label, jugador2Label, tiempoLabel;
    private JPanel infoPanel;
    enum Player {PLAYER_1, PLAYER_2}
    private Player currentPlayer = PLAYER_1;


    //-------------------------------------------------////-------------------------------------------------//
    public PoobStairsGUI(){
        String input = JOptionPane.showInputDialog(null, "Ingrese el tamaño del tablero:");
        String[] values = input.split(" ");
        NUM_ROWS = Integer.parseInt(values[0]);
        NUM_COLS = Integer.parseInt(values[1]);
        prepareElements();
        prepareElementsBoard(NUM_ROWS,NUM_COLS,UIManager.getColor("Button.background"));
        prepareAccions();
    }

    //------------------------------------------------- Elementos -------------------------------------------------//
    private void prepareElements() {
        //-------------------------------------------------//
        setTitle("PoobStairs");
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,Screen.width/2,Screen.height/2);
        setLocationRelativeTo(null);
        //-------------------------------------------------//
        prepareElementsMenu();
        //-------------------------------------------------//
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setPreferredSize(new Dimension(200, 100));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 100, 10, 10)));
        String jugador1 = JOptionPane.showInputDialog(null, "Nombre del jugador 1:");
        String jugador2 = JOptionPane.showInputDialog(null, "Nombre del jugador 2:");

        // Mostrar nombres de los jugadores
        jugador1Label = new JLabel("Player 1: " + jugador1, SwingConstants.CENTER);
        jugador1Label.setOpaque(true);
        jugador1Label.setBackground(java.awt.Color.RED);
        jugador1Label.setForeground(java.awt.Color.WHITE);
        jugador2Label = new JLabel("Player 2: " + jugador2, SwingConstants.CENTER);
        jugador2Label.setOpaque(true);
        jugador2Label.setBackground(java.awt.Color.BLUE);

        JPanel jugador1Panel = new JPanel();
        jugador1Panel.setLayout(new BoxLayout(jugador1Panel, BoxLayout.PAGE_AXIS));
        jugador1Panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        JLabel jugador1Nombre = new JLabel("Nombre jugador 1:" + jugador1);
        JLabel jugador1Color = new JLabel("Color: " + Jugador.colorToken);
        JLabel jugador1Numeroescaleras = new JLabel("Escaleras recorridas: " + Jugador.stairswalked);
        JLabel jugador1Numeroserpientes = new JLabel("Serpientes Recorridas: " + Jugador.snakesTraveled);
        JLabel jugador1Casillasespeciales = new JLabel("Casillas especiales: " + Jugador.checkboxesSpecialEnabled);
        JLabel jugador1Modificadores = new JLabel("Modificadores: " + Jugador.modifiersInValues);
        JLabel jugador1Casillamax = new JLabel("Maxima casilla: " + Jugador.maximaCasilla);
        jugador1Panel.add(Box.createVerticalGlue());
        jugador1Panel.add(jugador1Nombre);
        jugador1Panel.add(jugador1Color);
        jugador1Panel.add(jugador1Numeroescaleras);
        jugador1Panel.add(jugador1Numeroserpientes);
        jugador1Panel.add(jugador1Casillasespeciales);
        jugador1Panel.add(jugador1Modificadores);
        jugador1Panel.add(jugador1Casillamax);
        jugador1Panel.add(Box.createVerticalGlue());
        jugador1Label.setOpaque(true);
        jugador1Label.setForeground(java.awt.Color.WHITE);

        JPanel jugador2Panel = new JPanel();
        jugador2Panel.setLayout(new BoxLayout(jugador2Panel, BoxLayout.PAGE_AXIS));
        jugador2Panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        JLabel jugador2Nombre = new JLabel("Nombre jugador 2: " + jugador2 );
        JLabel jugador2Color = new JLabel("Color: " + Jugador.colorToken);
        JLabel jugador2Numeroescaleras = new JLabel("Escaleras recorridas: " + Jugador.stairswalked);
        JLabel jugador2Numeroserpientes = new JLabel("Serpientes Recorridas: " + Jugador.snakesTraveled);
        JLabel jugador2Casillasespeciales = new JLabel("Casillas especiales: " + Jugador.checkboxesSpecialEnabled);
        JLabel jugador2Modificadores = new JLabel("Modificadores: " + Jugador.modifiersInValues);
        JLabel jugador2Casillamax = new JLabel("Maxima casilla: " + Jugador.maximaCasilla);
        jugador2Panel.add(Box.createVerticalGlue());
        jugador2Panel.add(jugador2Nombre);
        jugador2Panel.add(jugador2Color);
        jugador2Panel.add(jugador2Numeroescaleras);
        jugador2Panel.add(jugador2Numeroserpientes);
        jugador2Panel.add(jugador2Casillasespeciales);
        jugador2Panel.add(jugador2Modificadores);
        jugador2Panel.add(jugador2Casillamax);
        jugador2Panel.add(Box.createVerticalGlue());
        jugador2Label.setOpaque(true);
        jugador2Label.setForeground(java.awt.Color.WHITE);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setPreferredSize(new Dimension(200, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(jugador1Panel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(jugador2Panel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(Box.createVerticalGlue());

        getContentPane().add(infoPanel, BorderLayout.WEST);
    }
    private void prepareElementsMenu() {
        barra = new JMenuBar();
        menu = new JMenu("Menú");
        Configuracion = new JMenu("Configuracion");
        //-------------------------------------------------//
        barra.add(menu);
        barra.add(Configuracion);
        //-------------------------------------------------//
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Saved = new JMenuItem("Saved");
        Restart = new JMenuItem("Restart");
        Exit = new JMenuItem("Exit");
        Color = new JMenuItem("Color");
        Tamaño = new JMenuItem("Tamaño");
        //-------------------------------------------------//
        Configuracion.add(Tamaño);
        Configuracion.addSeparator();
        Configuracion.add(Color);
        //-------------------------------------------------//
        menu.add(New);
        menu.addSeparator();
        menu.add(Open);
        menu.addSeparator();
        menu.add(Saved);
        menu.addSeparator();
        menu.add(Restart);
        menu.addSeparator();
        menu.add(Exit);
        //-------------------------------------------------//
        setJMenuBar(barra);
    }

    private void prepareElementsBoard(int numRows, int numCols,Color color) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        buttons = new JButton[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(color);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.weightx = 1.0 / numCols;
                gbc.weighty = 1.0 / numRows;
                gbc.ipadx = 150 / numCols;
                gbc.ipady = 350 / numRows;
                panel.add(buttons[row][col], gbc);

            }
        }
        //panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        getContentPane().add(panel, BorderLayout.CENTER);
    }
    //------------------------------------------------- Acciones -------------------------------------------------//
    private void prepareAccions() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        prepareAccionsMenu();
        prepareAccionsBoard();
    }

    private void prepareAccionsMenu() {

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                New();
            }
        });
        Open.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        Saved.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saved();
            }
        });
        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restart();
            }
        });
        Exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        Color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color();
            }
        });

        Tamaño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
    }

    private void prepareAccionsBoard() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getBackground().equals(UIManager.getColor("Button.background"))) {
                            if (currentPlayer == PLAYER_1) {
                                clickedButton.setBackground(java.awt.Color.RED);
                                currentPlayer = PLAYER_2;
                            } else {
                                clickedButton.setBackground(java.awt.Color.BLUE);
                                currentPlayer = PLAYER_1;
                            }
                        }
                    }
                });
            }
        }
    }

    //------------------------------------------------- Funciones -------------------------------------------------//
    private void saved() {
        Seleccion = new JFileChooser();
        Seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int opcion = Seleccion.showSaveDialog(this);
        if(opcion != JFileChooser.CANCEL_OPTION){
            File Archivo = Seleccion.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
        }
    }
    private void open() {
        Seleccion = new JFileChooser();
        Seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcion = Seleccion.showOpenDialog(this);
        if(opcion != JFileChooser.CANCEL_OPTION){
            File Archivo = Seleccion.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
        }
    }
    private void New() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no está implementado");
    }
    private void exit() {
        int result = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }
    }
    private void refresh() {
        infoPanel.repaint();
    }

    private void Color() {
        color = JColorChooser.showDialog(null,"Seleciona el color del tablero", java.awt.Color.WHITE);
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                buttons[row][col].setBackground(color);
            }
        }
    }

    private void Restart() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                buttons[row][col].setBackground(UIManager.getColor("Button.background"));
                buttons[row][col].setEnabled(true);
            }
        }
        currentPlayer = PLAYER_1;
        tiempoLabel.setText("Turno: 0");
    }
}
