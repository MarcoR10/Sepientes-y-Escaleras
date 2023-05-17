package domain;

public class CBox {
    private int Row;
    private int Col;
    private Modifiers Modificador;
    private int value;

    public CBox(int Row, int Col) {
        this.Row = Row;
        this.Col = Col;
        this.Modificador = null;
        this.value = 0;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getRow() {
        return Row;
    }

    public int getCol() {
        return Col;
    }

    public Modifiers getModificador() {
        return Modificador;
    }

    public void setModificador(Modifiers Modificador) {
        this.Modificador = Modificador;
    }
}

