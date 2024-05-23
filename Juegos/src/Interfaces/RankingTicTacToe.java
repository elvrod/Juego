package Interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingTicTacToe implements Ranking {
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

    @Override
    public int obtenerPosicion(String usuario) {
        List<Map.Entry<String, Integer>> sortedEntries = puntos.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());
        
        for (int i = 0; i < sortedEntries.size(); i++) {
            if (sortedEntries.get(i).getKey().equals(usuario)) {
                return i + 1; // Posiciones empiezan en 1
            }
        }
        return -1; // Usuario no encontrado en el ranking
    }
}
