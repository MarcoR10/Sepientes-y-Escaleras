package Presentation;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;

import java.awt.*;
import java.util.*;

import Domain.*;

public class BoardGUI extends JPanel{

    private PoobStairs Game;
    private JButton salir, backMainMenu, ReRoll;
    private JPanel board;
    private JPanel midPanel,titlePanel, dicePanel,DicePanel;
    private static final int SIZE = 10;
    private Color colorFondo = Color.white;
    private CBoxGUI[][] CBoxGUIS;
    private JLabel  textfield, imageLabel, jugadorEnTurno, moves;
    private HashMap<Color, TokenGUI> fichas;
    private Timer timer;
    private JFileChooser fileChooser;
    private boolean value;
    private int porcModif,diceShuffled,movimientos;

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    public BoardGUI(int nSerpientes, int nEscaleras, boolean hasEspeciales, int porcCasilla, int porcModif, HashMap<String, Color> jugadorColor){
        board = new JPanel();
        fichas = new HashMap<>();
        CBoxGUIS = new CBoxGUI[SIZE][SIZE];
        this.porcModif = porcModif/10;
        Game = getSnakesAndLadders(nSerpientes, nEscaleras, hasEspeciales, porcCasilla, porcModif, jugadorColor);
        prepareElements();
    }
    //-------------------------------------------------------------------------//
    private PoobStairs getSnakesAndLadders(int nSerpientes, int nEscaleras, boolean hasEspeciales, int porcCasilla, int porcModif, HashMap<String, Color> jugadorColor) {
        if(Game == null){
            Game = new PoobStairs(nSerpientes, nEscaleras, hasEspeciales, porcCasilla, jugadorColor);
        }
        return Game;
    }
    //-------------------------------------------------------------------------//
    public void prepareElements(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout(SIZE, SIZE));
        board.setBorder(BorderFactory.createMatteBorder(4,4,4,4,new Color(115,17,17)));
        prepareElementsBoard();
        prepareActionsBoard();
    }
    //-------------------------------------------------------------------------//
    public void prepareElementsBoard(){
        //-------------------------------------------------------------------------//
        board.setLayout(new GridLayout(10, 10));
        board.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder("Board ")));
        board.setBorder(new LineBorder(new Color(115,17,17), 3));
        //-------------------------------------------------------------------------//
        int n = 1;
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                CBoxGUIS[i][j] = new CBoxGUI();
                CBoxGUIS[i][j].setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
                CBoxGUIS[i][j].setLayout(new GridLayout(1, 5, 3, 3));
                board.add(CBoxGUIS[i][j]);
                CBoxGUIS[i][j].setFocusable(true);
            }
        }
        //-------------------------------------------------------------------------//
        for (int i = CBoxGUIS.length - 1; i >= 0; i--) {
            if (i % 2 != CBoxGUIS.length % 2) {
                for (int j = 0; j < CBoxGUIS[0].length; j++) {
                    CBoxGUIS[i][j].setText(n);
                    n +=1;
                }
            } else {
                for (int j = CBoxGUIS[0].length - 1; j >= 0; j--) {
                    CBoxGUIS[i][j].setText(n);
                    n +=1;
                }
            }
        }
        add(board);
        //-------------------------------------------------------------------------//
        midPanel = new JPanel();
        midPanel.setBorder(new LineBorder(new Color(115,17,17), 2));
        midPanel.setLayout(new BorderLayout());
        midPanel.setBackground(new Color(115,17,17));
        //-------------------------------------------------------------------------//
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(2, 1, 5, 5));
        JLabel textMovimientos = new JLabel(" Tirada :");
        textMovimientos.setForeground(Color.black);
        JLabel textFichas = new JLabel(" Turno :");
        textFichas.setForeground(Color.black);
        moves = new JLabel(Integer.toString(movimientos));
        String turnoJugador = Game.getJugadorEnTurno().getNombre();
        jugadorEnTurno = new JLabel(turnoJugador);
        stats.add(textMovimientos);
        stats.add(moves);
        stats.add(textFichas);
        stats.add(jugadorEnTurno);
        //-------------------------------------------------------------------------//
        salir = new JButton("Finalizar");
        midPanel.add(stats, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(salir);
        midPanel.add(buttonPanel, BorderLayout.SOUTH);
        dicePanel = new JPanel();
        dicePanel.setLayout(new BorderLayout(2, 1));
        imageLabel = new JLabel();
        imageLabel.setSize(512, 512);
        ReRoll = new JButton("Lanzar Dado");
        //-------------------------------------------------------------------------//
        DicePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diceSize = Math.min(getWidth(), getHeight()) - 20;
                int diceX = (getWidth() - diceSize) / 4;
                int diceY = (getHeight() - diceSize) / 4;
                g.setColor(Color.WHITE);
                g.fillRect(diceX, diceY, diceSize, diceSize);
                g.setColor(Color.BLACK);
                g.drawRect(diceX, diceY, diceSize, diceSize);
                int dotSize = diceSize / 7;
                int dotX = diceX + (diceSize - dotSize) / 4;
                int dotY = diceY + (diceSize - dotSize) / 4;
                g.setColor(Color.BLACK);
                switch (movimientos) {
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
        //-------------------------------------------------------------------------//
        dicePanel.add(ReRoll, BorderLayout.NORTH);
        dicePanel.add(DicePanel, BorderLayout.CENTER);
        midPanel.add(dicePanel, BorderLayout.CENTER);
        add(midPanel, BorderLayout.EAST);
        //-------------------------------------------------------------------------//
        for (String key : Game.getJugadores().keySet()) {
            Color tempColor = Game.getJugadores().get(key).getColorficha();
            int i = Game.getJugadores().get(key).getFichaJug().getPosX();
            int j = Game.getJugadores().get(key).getFichaJug().getPosY();
            fichas.put(tempColor, new TokenGUI(tempColor, i, j));
            CBoxGUIS[i][j].addFicha(fichas.get(tempColor));
        }
        //-------------------------------------------------------------------------//
        PintarCasillas();
        //-------------------------------------------------------------------------//
        HashMap<Integer, CBox> casillaHashMap = Game.getTablero().getCasillas();
        for(Integer key: casillaHashMap.keySet()){
            if (casillaHashMap.get(key) instanceof Jump){
                CBoxGUIS[casillaHashMap.get(key).getPosX()][casillaHashMap.get(key).getPosY()].setBackground(Color.RED);
            } else if (casillaHashMap.get(key) instanceof Mortal) {
                CBoxGUIS[casillaHashMap.get(key).getPosX()][casillaHashMap.get(key).getPosY()].setBackground(new Color(116, 0, 255));
            }
        }
    }
    //-------------------------------------------------------------------------////-------------------------------------------------------------------------//
    public void prepareActionsBoard(){
        salir.addActionListener(e -> salida());
        ReRoll.addActionListener(e -> {
            prepareMove();
        });
    }
    //----------------------------
    // ---------------------------------------------////-------------------------------------------------------------------------//
    private void PintarCasillas() {
        Random rand = new Random();
        HashMap<String, Item> powerUps = Game.getTablero().getItems();
        for (String key: powerUps.keySet()){
            Item temp = powerUps.get(key);
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            if (temp.isSnake()){
                CBoxGUIS[temp.getStartCoords()[0]][temp.getStartCoords()[1]].setBackground(new Color(0,100,250));
                CBoxGUIS[temp.getStartCoords()[0]][temp.getStartCoords()[1]].setColorTexto(new Color(r, g, b));
                CBoxGUIS[temp.getEndCoords()[0]][temp.getEndCoords()[1]].setBackground(new Color(0,50,150));
                CBoxGUIS[temp.getEndCoords()[0]][temp.getEndCoords()[1]].setColorTexto(new Color(r, g, b));
            }
            else {
                CBoxGUIS[temp.getStartCoords()[0]][temp.getStartCoords()[1]].setBackground(new Color(0,250,50));
                CBoxGUIS[temp.getStartCoords()[0]][temp.getStartCoords()[1]].setColorTexto(new Color(r, g, b));
                CBoxGUIS[temp.getEndCoords()[0]][temp.getEndCoords()[1]].setBackground(new Color(30,120,50));
                CBoxGUIS[temp.getEndCoords()[0]][temp.getEndCoords()[1]].setColorTexto(new Color(r, g, b));
            }
        }
        revalidate();
        repaint();
    }
    public void prepareMove(){
        int roll = Game.RollDice();
        if(new Random().nextInt(1, 11) <= porcModif){
            Random rand = new Random();
            int value = rand.nextInt(1,3);
            if(value == 1){
                if ((JOptionPane.showConfirmDialog(null, "Modificador obtenido! Avanzarás 1 casilla más de lo que indica el dado ¿Deseas usarlo?")) == JOptionPane.YES_OPTION){
                    roll +=1;
                }
            }
            else {
                if ((JOptionPane.showConfirmDialog(null, "Modificador obtenido! Retrocederás 1 casilla menos de lo que indica el dado ¿Deseas usarlo?")) == JOptionPane.YES_OPTION){
                    roll -=1;
                }
            }
        }

        moves.setText(Integer.toString(roll));
        int x = fichas.get(Game.getJugadorEnTurno().getColorficha()).getPosX();
        int y = fichas.get(Game.getJugadorEnTurno().getColorficha()).getPosY();
        move(x, y, roll);
    }
    public void move(int x, int y, int diceShuffled){
        CBoxGUIS[x][y].removeFicha(fichas.get(Game.getJugadorEnTurno().getColorficha()));
        int[] newPos = Game.move(diceShuffled);
        if(Game.gameHasWinner()){
            finishGame();
        }
        else{
            fichas.get(Game.getJugadorNotEnTurno().getColorficha()).setPosX(newPos[0]);
            fichas.get(Game.getJugadorNotEnTurno().getColorficha()).setPosY(newPos[1]);
            CBoxGUIS[newPos[0]][newPos[1]].addFicha(fichas.get(Game.getJugadorNotEnTurno().getColorficha()));
            jugadorEnTurno.setText(Game.getJugadorEnTurno().getNombre());
            nextMovement();
        }
    }
    public void moveMaquina(){
        PintarCasillas();
        int dice = Game.RollDice();
        moves.setText(Integer.toString(diceShuffled));
        int x = fichas.get(Game.getJugadorEnTurno().getColorficha()).getPosX();
        int y = fichas.get(Game.getJugadorEnTurno().getColorficha()).getPosY();
        CBoxGUIS[x][y].removeFicha(fichas.get(Game.getJugadorEnTurno().getColorficha()));
        int[] newPos = Game.move(dice);
        if(Game.gameHasWinner()){
            finishGame();
        }
        else{
            fichas.get(Game.getJugadorNotEnTurno().getColorficha()).setPosX(newPos[0]);
            fichas.get(Game.getJugadorNotEnTurno().getColorficha()).setPosY(newPos[1]);
            CBoxGUIS[newPos[0]][newPos[1]].addFicha(fichas.get(Game.getJugadorNotEnTurno().getColorficha()));
            jugadorEnTurno.setText(Game.getJugadorEnTurno().getNombre());
            timer.stop();
            nextMovement();
        }
    }
    public void nextMovement(){
        if(Game.getJugadorEnTurno().getNombre().equals("Máquina")){
            timer = new Timer(1000, e -> moveMaquina());
            timer.start();
        }
        else{
            JOptionPane panel = new JOptionPane(Game.getJugadorEnTurno().getNombre() + ", Es tu turno : ", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = panel.createDialog(null, "Title");
            dialog.setModal(false);
            dialog.setVisible(true);
            new Timer(1500, e -> dialog.setVisible(false)).start();
        }
    }
    public void finishGame(){
        ReRoll.setEnabled(false);
        JOptionPane.showMessageDialog(null, Game.getGanador().getNombre() + " Es el GANADOR");
        String[] options ={"Nueva partida", "Salir"};
        var selection = JOptionPane.showOptionDialog(null, "Deseas Iniciar una nueva partida o finalizar el juego", "Advertencia",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(selection == JOptionPane.YES_OPTION){
            MenuGUI.getGUI().restartGame();
        } else if (selection == JOptionPane.NO_OPTION) {
            MenuGUI.getGUI().finishGame();
        }
    }

    private void salida(){
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

