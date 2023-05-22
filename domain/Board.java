package domain;

public class Board {

    private CBox[][] Casillas;

    public Board(int NumRow, int NumCol ) {
        Casillas = new CBox[NumRow][NumCol];
        IniciarT(NumRow,NumCol);
    }

    public void IniciarT(int NumRow, int NumCol){
        for(int x = 0;x<NumRow;x++){
            for(int y = 0;y<NumCol;y++){
                CBox Casilla =  new CBox(x,y);
                Casillas[x][y] =  Casilla;
            }
        }
    }
    public CBox getCasillas(int x,int y) {
        return Casillas[x][y];
    }
}

