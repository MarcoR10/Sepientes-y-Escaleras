package Presentation;

import Domain.PoobStairsException;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Configuracion2 extends JPanel {
    private JLabel escalerasText, serpientesText, transformText, casillaText, modifText, tableroText, title;
    private JTextField escaleraInput, serpienteInput;
    private JRadioButton transformSelectYes, transformSelectNo;
    private JComboBox<String> casillaSelect, modifSelect, tableroSelect;
    private JPanel configPanel;
    private JButton returnMenu, confirm;
    private HashMap<String, Color> jugadores;
    int nSerpientes, nEscaleras, porcCasilla, porcModif;
    boolean hasEspeciales;
    public Configuracion2(HashMap<String, Color> jugadores){
        this.jugadores = jugadores;
        System.out.println(jugadores.size());
        prepareElements();
        prepareActions();
    }

    public void prepareElements(){
        //-------------------------------------------------------------------------//
        setLayout(new BorderLayout());
        configPanel = new JPanel();
        configPanel.setBackground(Color.RED);
        configPanel.setBackground(new Color(115,17,17));
        configPanel.setSize(new Dimension(300, 300));
        configPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //-------------------------------------------------------------------------//
        escalerasText = new JLabel("Número de escaleras");
        escalerasText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        escalerasText.setForeground(Color.white);
        c.insets = new Insets(0,100,0,0);
        c.weighty = 4;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        configPanel.add(escalerasText, c);
        //-------------------------------------------------------------------------//
        escaleraInput = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 0;
        configPanel.add(escaleraInput, c);
        //-------------------------------------------------------------------------//
        serpientesText = new JLabel("Número de serpientes");
        serpientesText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        serpientesText.setForeground(Color.white);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 0;
        c.gridy = 2;
        configPanel.add(serpientesText, c);
        //-------------------------------------------------------------------------//
        serpienteInput = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 2;
        configPanel.add(serpienteInput, c);
        //-------------------------------------------------------------------------//
        transformText = new JLabel("Escaleras y serpientes cambiables");
        transformText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        transformText.setForeground(Color.white);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 20;
        c.gridx = 0;
        c.gridy = 4;
        configPanel.add(transformText, c);
        transformSelectYes = new JRadioButton("Sí");
        transformSelectNo = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();
        group.add(transformSelectYes);
        group.add(transformSelectNo);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 4;
        configPanel.add(transformSelectYes, c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 8;
        c.gridy = 4;
        configPanel.add(transformSelectNo, c);
        //-------------------------------------------------------------------------//
        casillaText = new JLabel("Porcentaje de casillas especiales");
        casillaText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        casillaText.setForeground(Color.white);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 0;
        c.gridy = 6;
        configPanel.add(casillaText, c);
        casillaSelect = new JComboBox<String>();
        casillaSelect.addItem("");
        casillaSelect.addItem("0");
        casillaSelect.addItem("10");
        casillaSelect.addItem("20");
        casillaSelect.addItem("30");
        casillaSelect.addItem("40");
        casillaSelect.addItem("50");
        casillaSelect.addItem("60");
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 6;
        configPanel.add(casillaSelect, c);
        //-------------------------------------------------------------------------//
        modifText = new JLabel("Porcentaje de modificación de valores");
        modifText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 20));
        modifText.setForeground(Color.white);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 0;
        c.gridy = 8;
        configPanel.add(modifText, c);
        modifSelect = new JComboBox<String>();
        modifSelect.addItem("");
        modifSelect.addItem("0");
        modifSelect.addItem("10");
        modifSelect.addItem("20");
        modifSelect.addItem("30");
        modifSelect.addItem("40");
        modifSelect.addItem("50");
        modifSelect.addItem("60");
        c.fill = GridBagConstraints.NONE;
        c.weighty = 40;
        c.gridx = 5;
        c.gridy = 8;
        configPanel.add(modifSelect, c);
        //-------------------------------------------------------------------------//
        confirm = new JButton("Iniciar Juego");
        add(configPanel);
        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1,2, 10,10));
        botones.add(confirm);
        add(botones, BorderLayout.SOUTH);
        //-------------------------------------------------------------------------//
    }

    public void prepareActions(){
        confirm.addActionListener(e -> {
            try {
                startGame();
            } catch (PoobStairsException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Oops", JOptionPane.WARNING_MESSAGE);
                reset();
            }
        });
    }

    public void startGame() throws PoobStairsException {
        if (serpienteInput.getText().equals("") || escaleraInput.getText().equals("") || casillaSelect.getSelectedIndex() == 0 || modifSelect.getSelectedIndex() == 0){
            throw new PoobStairsException(PoobStairsException.SKIP_INFORMATION);
        }
        nSerpientes = Integer.parseInt(serpienteInput.getText());
        nEscaleras = Integer.parseInt(escaleraInput.getText());
        if(nSerpientes >= 10 || nEscaleras >= 10){
            throw new PoobStairsException(PoobStairsException.DEMASIADOS_ITEMS);
        }
        hasEspeciales = transformSelectYes.isSelected();
        porcCasilla = Integer.parseInt(String.valueOf(casillaSelect.getSelectedItem()));
        porcModif = Integer.parseInt(String.valueOf(modifSelect.getSelectedItem()));
        MenuGUI.getGUI().prepareElementsBoard(nSerpientes, nEscaleras, hasEspeciales, porcCasilla, porcModif, jugadores);
    }
    public void reset(){
        serpienteInput.setText("");
        escaleraInput.setText("");
        casillaSelect.setSelectedIndex(0);
        modifSelect.setSelectedIndex(0);
        transformSelectYes.setSelected(false);
        transformSelectNo.setSelected(false);
    }
}
