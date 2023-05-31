package Domain;

import java.util.Random;

public class Jump extends CBox {
    private int saltos;
    public Jump(int n) {
        super(n);
        this.saltos = new Random().nextInt(3, 10);
    }

    public int getSaltos() {
        return saltos;
    }
}
