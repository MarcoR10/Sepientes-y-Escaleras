package Domain;

import java.util.ArrayList;

public class Question extends CBox {

    private ArrayList<String> preguntas;
    private ArrayList<Boolean> respuestas;
    public Question(int n) {
        super(n);
        preguntas = new ArrayList<>();
        respuestas = new ArrayList<>();
        preguntas.add("El Monte Everest es la montaña más alta del mundo");
        respuestas.add(true);
        preguntas.add("La Mona Lisa fue pintada por el artista renacentista Leonardo da Vinci.");
        respuestas.add(true);
        preguntas.add("Los pingüinos pueden volar.");
        respuestas.add(false);
        preguntas.add("El río Amazonas es el río más largo del mundo.");
        respuestas.add(true);
        preguntas.add("La estatua de la Libertad fue un regalo de Francia a los Estados Unidos.");
        respuestas.add(true);
        preguntas.add("La estatua de la Libertad fue un regalo de Francia a los Estados Unidos.");
        respuestas.add(false);
        preguntas.add("El ajedrez es un deporte olímpico reconocido.");
        respuestas.add(false);
        preguntas.add("La Mona Lisa se exhibe en el Museo del Louvre en París.");
        respuestas.add(true);
        preguntas.add("El idioma más hablado en el mundo es el inglés. ");
        respuestas.add(false);
        preguntas.add("El Polo Norte es un continente.");
        respuestas.add(false);
    }

    public boolean ask(){
        return true;
    }
}
