package Interfaces;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<String> historial;

    public Historial() {
        historial = new ArrayList<>();
    }

    public void agregarPartida(String resultado) {
        historial.add(resultado);
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}
