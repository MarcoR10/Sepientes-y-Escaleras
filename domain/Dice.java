package Domain;

import java.util.Random;

public class Dice {
    public int Face;
    public int cara;

    public Dice(){
        this.Face = 6;
    }

    public int Roll(){
        Random random = new Random();
        cara = random.nextInt(Face)+1;
        return cara;
    }
}
