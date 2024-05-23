package Interfaces;

import java.util.HashMap;
import java.util.Map;

public class RankingTicTacToe {
    private Map<String, Integer> puntos;

    public RankingTicTacToe() {
        puntos = new HashMap<>();
    }

    public void actualizarPuntos(String jugador, int puntosObtenidos) {
        puntos.put(jugador, puntos.getOrDefault(jugador, 0) + puntosObtenidos);
    }

    public String mostrarRanking() {
        StringBuilder ranking = new StringBuilder("Ranking 3 en Raya:\n");
        puntos.forEach((jugador, puntos) -> ranking.append(jugador).append(": ").append(puntos).append("\n"));
        return ranking.toString();
    }
}
