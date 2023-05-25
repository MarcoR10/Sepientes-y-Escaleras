package domain;

public class CBox {
    private int col,row,Val;
    private Token ficha;
    public CBox(int row,int col ) {
        this.row = row;
        this.col = col;
        this.ficha = null;
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
    public int getVal() {
        return Val;
    }
}

