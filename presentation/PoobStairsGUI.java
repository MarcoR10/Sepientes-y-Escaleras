package presentation;

import domain.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import domain.Dice;

public class PoobStairsGUI extends JFrame {
    //-------------------------------------------------Atributos-------------------------------------------------//
    private int NUM_ROWS = 10,NUM_COLS = 10,diceResult;
    private java.awt.Color color;
    private JButton[][] buttons;
    private JMenuBar barra;
    private JMenu menu,Configuracion;
    private JMenuItem New, Open, Saved, Restart,Color, Exit,Tamaño;
    private JFileChooser Seleccion;
    private JLabel jugador1Label, jugador2Label, tiempoLabel,diceResultLabel;
    private JPanel infoPanel,DicePanel;
    private PoobStairs Game;
    private JButton rollButton;
    private Dice dado = new Dice(6);

    //-------------------------------------------------////-------------------------------------------------//
    public PoobStairsGUI(){
        //Tablero();
        Game = new PoobStairs();
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

        //-------------------------------------------------//
        // Mostrar nombres de los jugadores
        jugador1Label = new JLabel("Player 1: " , SwingConstants.CENTER);
        jugador1Label.setOpaque(true);
        jugador1Label.setBackground(java.awt.Color.RED);
        jugador1Label.setForeground(java.awt.Color.WHITE);
        jugador2Label = new JLabel("Player 2: " , SwingConstants.CENTER);
        jugador2Label.setOpaque(true);
        jugador2Label.setBackground(java.awt.Color.BLUE);
        //-------------------------------------------------//
        JPanel jugador1Panel = new JPanel();
        jugador1Panel.setLayout(new BoxLayout(jugador1Panel, BoxLayout.PAGE_AXIS));
        jugador1Panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        JLabel jugador1Nombre = new JLabel("Nombre jugador 1:");
        JLabel jugador1Color = new JLabel("Color: ");
        JLabel jugador1Numeroescaleras = new JLabel("Escaleras recorridas: ");
        JLabel jugador1Numeroserpientes = new JLabel("Serpientes Recorridas: ");
        JLabel jugador1Casillasespeciales = new JLabel("Casillas especiales: ");
        JLabel jugador1Modificadores = new JLabel("Modificadores: ");
        JLabel jugador1Casillamax = new JLabel("Maxima casilla: ");
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
        //-------------------------------------------------//
        JPanel jugador2Panel = new JPanel();
        jugador2Panel.setLayout(new BoxLayout(jugador2Panel, BoxLayout.PAGE_AXIS));
        jugador2Panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        JLabel jugador2Nombre = new JLabel("Nombre jugador 2: ");
        JLabel jugador2Color = new JLabel("Color: ");
        JLabel jugador2Numeroescaleras = new JLabel("Escaleras recorridas: ");
        JLabel jugador2Numeroserpientes = new JLabel("Serpientes Recorridas: ");
        JLabel jugador2Casillasespeciales = new JLabel("Casillas especiales: ");
        JLabel jugador2Modificadores = new JLabel("Modificadores: ");
        JLabel jugador2Casillamax = new JLabel("Maxima casilla: ");
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
        //-------------------------------------------------//
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
        //-------------------------------------------------//
        DicePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diceSize = Math.min(getWidth(), getHeight()) - 20;
                int diceX = (getWidth() - diceSize) / 4;
                int diceY = (getHeight() - diceSize) / 4;
                g.setColor(java.awt.Color.WHITE);
                g.fillRect(diceX, diceY, diceSize, diceSize);
                g.setColor(java.awt.Color.BLACK);
                g.drawRect(diceX, diceY, diceSize, diceSize);
                int dotSize = diceSize / 7;
                int dotX = diceX + (diceSize - dotSize) / 4;
                int dotY = diceY + (diceSize - dotSize) / 4;
                g.setColor(java.awt.Color.BLACK);
                switch (diceResult) {
                    case 1:
                        g.fillOval(dotX + diceSize / 4, dotY + diceSize / 4, dotSize, dotSize);
                        break;
                    case 2:
                        g.fillOval(dotX, dotY, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 2, dotSize, dotSize);
                        break;
                    case 3:
                        g.fillOval(dotX, dotY, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 4, dotY + diceSize / 4, dotSize, dotSize);
                        break;
                    case 4:
                        g.fillOval(dotX, dotY, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY, dotSize, dotSize);
                        g.fillOval(dotX, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 2, dotSize, dotSize);
                        break;
                    case 5:
                        g.fillOval(dotX, dotY, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY, dotSize, dotSize);
                        g.fillOval(dotX, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 4, dotY + diceSize / 4, dotSize, dotSize);
                        break;
                    case 6:
                        g.fillOval(dotX, dotY, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY, dotSize, dotSize);
                        g.fillOval(dotX, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 2, dotSize, dotSize);
                        g.fillOval(dotX, dotY + diceSize / 4, dotSize, dotSize);
                        g.fillOval(dotX + diceSize / 2, dotY + diceSize / 4, dotSize, dotSize);
                        break;
                }
            }
        };
        diceResultLabel = new JLabel("Resultado: ");
        rollButton = new JButton("Tirar Dado");
        DicePanel.add(diceResultLabel);
        DicePanel.add(rollButton);
        getContentPane().add(DicePanel, BorderLayout.EAST);
        //-------------------------------------------------//
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
        //-------------------------------------------------//
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
        int cont = 0;
        for(int row = NUM_ROWS-1;row >= 0;row--){
            if (row % 2 == 0){
                for(int col = NUM_COLS-1;col >= 0;col--){
                    buttons[row][col].setText(String.valueOf(cont));
                    cont += 1;
                }
            }else{
                for(int col = 0;col < NUM_COLS;col++){
                    buttons[row][col].setText(String.valueOf(cont));
                    cont += 1;
                }
            }

        }
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

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diceResult = dado.Roll();
                diceResultLabel.setText("Resultado: " + diceResult);
                DicePanel.repaint();
            }
        });
    }

    private void prepareAccionsBoard() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }
        }

    }

    //------------------------------------------------- Funciones -------------------------------------------------//

    private void Tablero(){
        //String input = JOptionPane.showInputDialog(null, "Ingrese el numero de filas del tablero:");
        //NUM_ROWS = Integer.parseInt(input);
        //String input2 = JOptionPane.showInputDialog(null, "Ingrese el numero de Columnas del tablero:");
        //NUM_COLS = Integer.parseInt(input2);
    }
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
        tiempoLabel.setText("Turno: 0");
    }
}
