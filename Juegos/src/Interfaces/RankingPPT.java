package Interfaces;

import java.util.HashMap;
import java.util.Map;

public class RankingPPT {
    private Map<String, Integer> puntos;

    public RankingPPT() {
        puntos = new HashMap<>();
    }

    public void actualizarPuntos(String jugador, int puntosObtenidos) {
        puntos.put(jugador, puntos.getOrDefault(jugador, 0) + puntosObtenidos);
    }

    public String mostrarRanking() {
        StringBuilder ranking = new StringBuilder("Ranking Piedra, Papel, Tijera:\n");
        puntos.forEach((jugador, puntos) -> ranking.append(jugador).append(": ").append(puntos).append("\n"));
        return ranking.toString();
    }
}
