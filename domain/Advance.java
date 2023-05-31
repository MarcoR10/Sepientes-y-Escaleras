package Domain;

import java.util.HashMap;

public class Advance extends CBox {
    public Advance(int n) {
        super(n);
    }
    public int[] getNearestItem(HashMap<String, Item> items){
        int[] nearestcoords = null;
        int nearestCasilla = 100;
        int newCasilla = 0;
        for (String key: items.keySet()){
            if ((items.get(key).getStart() > getNumero()) &&((items.get(key).getStart() - getNumero()< nearestCasilla)) && items.get(key).isLadder()){
                nearestcoords = items.get(key).getStartCoords();
                newCasilla = items.get(key).getEnd();
            }
        }
        assert nearestcoords != null;
        return new int[] {nearestcoords[0], nearestcoords[1], newCasilla};
    }
}
