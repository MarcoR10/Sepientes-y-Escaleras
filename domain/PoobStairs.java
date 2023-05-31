package Domain;

import java.awt.*;
import java.util.HashMap;

public class PoobStairs {
    private static Board board;
    private static HashMap<String, Player> jugadores;
    private Player ganador;
    private Dice dice;
    private static int turno;
    private boolean hasWinner;

    /**
     * Constructor de objetos tipo SnakesAndLadders
     *
     * @param nSerpientes   numero de Serpientes
     * @param nEscaleras    número de Escaleras
     * @param hasEspeciales Define si las escaleras o serpientes cambian
     * @param porcCasilla   Porcentaje de casillas Especiales
     * @param infoJugador   información de los jugadores
     */
    public PoobStairs(int nSerpientes, int nEscaleras, boolean hasEspeciales, int porcCasilla, HashMap<String, Color> infoJugador) {
        jugadores = new HashMap<>();
        Start(nSerpientes, nEscaleras,hasEspeciales, porcCasilla, infoJugador);
        dice = new Dice();
        for (String key : jugadores.keySet()) {
            board.putFichaAtStart(jugadores.get(key).getFichaJug());
        }
        turno = 0;
    }

    /**
     * Inicia el juego
     *
     * @param nSerpientes   numero de Serpientes
     * @param nEscaleras    número de Escaleras
     * @param areChangeable Define si las escaleras o serpientes cambian
     * @param porcCasilla   Porcentaje de casillas Especiales
     * @param infoJugador   información de los jugadores
     */
    public void Start(int nSerpientes, int nEscaleras, boolean areChangeable, int porcCasilla, HashMap<String, Color> infoJugador) {
        int i = 0;
        for (String key : infoJugador.keySet()) {
            if (!key.equals("Máquina")) {
                Human jugador = new Human(key, infoJugador.get(key));
                jugadores.put(key, jugador);
            } else {
                Machine cpu = new Machine(key, infoJugador.get(key));
                jugadores.put(key, cpu);
            }
            jugadores.get(key).setTurno(i);
            i +=1;
        }
        System.out.println(jugadores.size());
        board = new Board(nSerpientes, nEscaleras,areChangeable, porcCasilla);
    }

    /**
     * Mueve las fichas en el tablero
     * @param shuffleDice Valor del dado lanzado
     * @return Posiciones a actualizar en la capa de presentación
     */
    public int[] move(int shuffleDice){
        //System.out.println(getJugadorEnTurno().getNombre());
        int[] newPositionsGUI;
        newPositionsGUI = board.move(shuffleDice, getJugadorEnTurno());
        if(checkIfWinner(getJugadorEnTurno())){
            endGame();
        }
        if(turno == 1){
            turno = 0;
        }
        else{
            turno += 1;
        }    
        return newPositionsGUI;
    }

    /**
     * Retorna el jugador en turno
     * @return Jugador en turno
     */
    public static Player getJugadorEnTurno(){
        Player enTurno = null;
        for (String key : jugadores.keySet()) {
            if(jugadores.get(key).getTurno() == turno){
                enTurno = jugadores.get(key);
            }
        }
        return enTurno;
    }

    /**
     * Retorna el jugador que no es su turno
     * @return Jugador que no es su turno
     */
    public Player getJugadorNotEnTurno(){
        Player enTurno = null;
        for (String key : jugadores.keySet()) {
            if(jugadores.get(key).getTurno() != turno){
                enTurno = jugadores.get(key);
            }
        }
        return enTurno;
    }

    /**
     * Lanza el dado
     * @return El valor del dado lanzado
     */
    public int RollDice(){
        return dice.Roll();
    }

    /**
     * Retorna el tablero
     * @return el tablero del juego
     */
    public Board getTablero() {
        return board;
    }


    /**
     * Se encarga de confirmar si hay un ganador con base en la posición de las fichas del jugador en turno
     * @param player Jugador en turno
     * @return true si hay ganador, false si no
     */
    public boolean checkIfWinner(Player player){
        boolean value = false;
        if (player.getFichaJug().getPosX() == 0 && player.getFichaJug().getPosY()==0){
            player.hasWon();
            value = true;
        }
        return value;
    }

    /**
     * Retorna los jugadores de la partida
     * @return Jugadores de la partida
     */
    public HashMap<String, Player> getJugadores() {
        return jugadores;
    }

    /**
     * Finaliza el juego lógicamente
     */
    public void endGame(){
        ganador = getJugadorEnTurno();
        ganador.hasWon();
        hasWinner = true;
        board = null;
        jugadores = null; 
        
    }

    /**
     * Retorna el jugador que ha ganado el juego para poder finalizarlo gráficamente
     * @return El jugador ganador del juego
     */
    public Player getGanador() {
        return ganador;
    }

    /**
     * informa si hay un ganador del juego
     * @return true si hay un ganador, false si no
     */
    public boolean gameHasWinner(){
        return hasWinner;
    }

}
