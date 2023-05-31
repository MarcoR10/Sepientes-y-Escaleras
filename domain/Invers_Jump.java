package Domain;

import java.util.Random;

public class Invers_Jump extends CBox {
    private int saltos;

    public Invers_Jump(int n) {
        super(n);
        this.saltos = new Random().nextInt(3, 10);
    }

    public int getSaltos() {
        return saltos;
    }
}
