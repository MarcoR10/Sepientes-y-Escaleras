package domain;

public class Board {
    private CBox[][] Casillas;

    public Board(int NumRow, int NumCol ) {
        Casillas = new CBox[NumRow][NumCol];
        IniciarT(NumRow,NumCol);
    }

    public void IniciarT(int NumRow, int NumCol){
        int cont = 0;
        for(int row = NumRow-1;row >= 0;row--){
            if (row % 2 == 0){
                for(int col = NumCol-1;col >= 0;col--){
                    CBox Casilla =  new CBox(row,col);
                    Casillas[row][col] =  Casilla;
                    cont += 1;
                }
            }else{
                for(int col = 0;col < NumCol;col++){
                    CBox Casilla =  new CBox(row,col);
                    Casillas[row][col] =  Casilla;
                    cont += 1;
                }
            }
        }
    }
    public void colocarFicha(int Fila, int Columna, Token ficha) {
            Casillas[Fila][Columna].setFicha(ficha);
    }
    public CBox getCasillas(int x,int y) {
        return Casillas[x][y];
    }
}

