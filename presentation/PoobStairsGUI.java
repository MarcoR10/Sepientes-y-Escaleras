package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

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
    private enum Player {PLAYER_1, PLAYER_2}
    private Player currentPlayer = Player.PLAYER_1;
    //-------------------------------------------------////-------------------------------------------------//
    public PoobStairsGUI(){
        String input = JOptionPane.showInputDialog(null, "Ingrese el tamaño del tablero:");
        String[] values = input.split(" ");
        NUM_ROWS = Integer.parseInt(values[0]);
        NUM_COLS = Integer.parseInt(values[1]);
        prepareElements();
        prepareElementsBoard(NUM_ROWS,NUM_COLS,UIManager.getColor("Button.background") );
        prepareAccions();
    }

    //------------------------------------------------- Elementos -------------------------------------------------//
    private void prepareElements() {
        //-------------------------------------------------//
        setTitle("Conecta4");
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,Screen.width/2,Screen.height/2);
        setLocationRelativeTo(null);
        //-------------------------------------------------//
        prepareElementsMenu();
        //-------------------------------------------------//
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setPreferredSize(new Dimension(200, 10));
        infoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 100, 10, 10)));
        jugador1Label = new JLabel("Player 1: Red", SwingConstants.CENTER);
        jugador1Label.setOpaque(true);
        jugador1Label.setBackground(java.awt.Color.RED);
        jugador1Label.setForeground(java.awt.Color.WHITE);
        jugador2Label = new JLabel("Player 2: Blue", SwingConstants.CENTER);
        jugador2Label.setOpaque(true);
        jugador2Label.setBackground(java.awt.Color.BLUE);
        tiempoLabel = new JLabel("Turno: 0", SwingConstants.CENTER);
        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(jugador1Label);
        infoPanel.add(jugador2Label);
        infoPanel.add(tiempoLabel);
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
                            if (currentPlayer == Player.PLAYER_1) {
                                clickedButton.setBackground(java.awt.Color.RED);
                                currentPlayer = Player.PLAYER_2;
                            } else {
                                clickedButton.setBackground(java.awt.Color.BLUE);
                                currentPlayer = Player.PLAYER_1;
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
        currentPlayer = Player.PLAYER_1;
        //jugador1Label.setBackground(java.awt.Color.RED);
        //jugador2Label.setBackground(java.awt.Color.BLUE);
        tiempoLabel.setText("Turno: 0");
    }
    //-------------------------------------------------////-------------------------------------------------//
}
