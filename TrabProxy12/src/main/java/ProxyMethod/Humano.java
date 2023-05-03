package ProxyMethod;

import java.util.Arrays;
import java.util.List;

public class Humano implements IHumano {

    private Integer sequenciaGenetica;
    private String nome;
    private String cidade;
    private Float senha1;
    private Float senha2;

    public Humano(int sequenciaGenetica) {
        this.sequenciaGenetica = sequenciaGenetica;
        Humano objeto = BioComputador.getHumano(sequenciaGenetica);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.senha1 = objeto.senha1;
        this.senha2 = objeto.senha2;
    }

    public Humano(Integer sequenciaGenetica, String nome, String cidade, Float senha1, Float senha2) {
        this.sequenciaGenetica = sequenciaGenetica;
        this.nome = nome;
        this.cidade = cidade;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }

    public Integer getSequenciaGenetica() {
        return sequenciaGenetica;
    }

    @Override
    public List<String> obterInfo() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterSenhas(AgenteCIA agenteCIA) {
        return Arrays.asList(this.senha1, this.senha2);
    }
}