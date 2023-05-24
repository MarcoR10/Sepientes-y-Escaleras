package domain;

import java.util.Random;

public class Dice {
    public int Face;
    public int cara;

    public Dice(int Face){
        this.Face = Face;
    }
    public int Roll(){
        Random random = new Random();
        cara = random.nextInt(Face)+1;
        return cara;
    }

    public int getFace() {
        return Face;
    }
}
