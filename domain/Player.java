package Domain;


import java.awt.Color;

public abstract class Player {
    private String nombre;
    private Color colorficha;
    private Token tokenJug;
    private boolean isWinner;
    private int turno;

    public Player(String name, Color color){
        this.nombre = name;
        this.colorficha = color;
        tokenJug = new Token(colorficha);
    }

    public Color getColorficha() {
        return colorficha;
    }

    public Token getFichaJug() {
        return tokenJug;
    }

    public int getTurno() {
        return turno;
    }

    public void hasWon(){
        isWinner = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
