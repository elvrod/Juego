package Interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public abstract class Ranking {
    protected Map<String, Integer> puntos;

    public Ranking() {
        puntos = new HashMap<>();
    }

    public void actualizarPuntos(String usuario, int puntosGanados) {
        puntos.put(usuario, puntos.getOrDefault(usuario, 0) + puntosGanados);
    }

    public int obtenerPuntos(String usuario) {
        return puntos.getOrDefault(usuario, 0);
    }

    public int obtenerPosicion(String usuario) {
        List<Map.Entry<String, Integer>> ranking = puntos.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < ranking.size(); i++) {
            if (ranking.get(i).getKey().equals(usuario)) {
                return i + 1;
            }
        }
        return -1; // Usuario no encontrado
    }

    public String mostrarRanking() {
        StringBuilder ranking = new StringBuilder();
        puntos.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> ranking.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));
        return ranking.toString();
    }
}
