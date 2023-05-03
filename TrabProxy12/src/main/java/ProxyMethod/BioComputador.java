package ProxyMethod;

import java.util.HashMap;
import java.util.Map;

public class BioComputador {
    private static Map<Integer, Humano> humanos = new HashMap<>();

    public static Humano getHumano(Integer sequenciaGenetica) {
        return humanos.get(sequenciaGenetica);
    }

    public static void addHumano(Humano humano) {
       humanos.put(humano.getSequenciaGenetica(), humano);
    }
}

