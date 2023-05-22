package domain;

public class CBox {
    private int Row,Col,Val;
    private Token ficha;



    public CBox(int Col, int Row) {
        this.Row = Row;
        this.Col = Col;
        this.ficha = null;
        this.Val = 0;
    }
    public Token getToken(){
        return ficha;
    }
    public void setFicha(Token ficha) {
        this.ficha = ficha;
    }
    public void nullFicha(){
        ficha =  null;
    }
    public int getRow() {
        return Row;
    }
    public int getCol() {
        return Col;
    }
    public void setVal(int val) {
        Val = val;
    }
}

