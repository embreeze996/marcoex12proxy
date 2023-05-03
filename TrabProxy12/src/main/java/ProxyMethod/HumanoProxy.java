package ProxyMethod;

import java.util.List;

public class HumanoProxy implements IHumano {

    private Humano humano;

    private Integer sequenciaGenetica;

    public HumanoProxy(Integer sequenciaGenetica) {

        this.sequenciaGenetica = sequenciaGenetica;
    }

    @Override
    public List<String> obterInfo() {
        if (this.humano == null) {
            this.humano = new Humano(this.sequenciaGenetica);
        }
        return this.humano.obterInfo();
    }

    @Override
    public List<Float> obterSenhas(AgenteCIA agenteCIA) {
        if (!agenteCIA.isAutorizado()) {
            throw new IllegalArgumentException("Agente da CIA não identificado, saia imediatamente!");
        }
        if (this.humano == null) {
            this.humano = new Humano(this.sequenciaGenetica);
        }
        return this.humano.obterSenhas(agenteCIA);
    }
}
