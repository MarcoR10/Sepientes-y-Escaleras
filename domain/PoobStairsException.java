package Domain;

public class PoobStairsException extends Exception{
    public static final String SKIP_INFORMATION = "Dejaste algunos espacio sin escoger, por favor completa la configuracion";
    public static final String SAMECOLOR_SAMENAME = "Un jugador tiene  el mismo nombre o color, verifica la información";
    public static final String DEMASIADOS_ITEMS = "Ingresaste un número muy grande de escaleras o serpientes, digita un valor menor a 10";
    public PoobStairsException(String message){
        super(message);
    }
}
