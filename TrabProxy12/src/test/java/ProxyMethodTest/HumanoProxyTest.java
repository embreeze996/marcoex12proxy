package ProxyMethodTest;

import ProxyMethod.AgenteCIA;
import ProxyMethod.BioComputador;
import ProxyMethod.Humano;
import ProxyMethod.HumanoProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HumanoProxyTest {

    @BeforeEach
    void setUp() {
        BioComputador.addHumano(new Humano(1, "Pablo", "México", 887878.0f, 976765.0f));
        BioComputador.addHumano(new Humano(4, "Inácio", "Europa", 353570.0f, 373775.0f));
    }

    @Test
    void deveRetornarInfoHumano() {
        HumanoProxy humano = new HumanoProxy(1);

        assertEquals(Arrays.asList("Pablo", "México"), humano.obterInfo());
    }

    @Test
    void deveRetornarSenhasHumano() {
        AgenteCIA agenteCIA = new AgenteCIA("Ana", true);
       HumanoProxy humano = new HumanoProxy(2);

        assertEquals(Arrays.asList(10.0f, 10.0f), humano.obterSenhas(agenteCIA));
    }

    @Test
    void deveRetonarExcecaoNaoAutorizadoConsultarSenhas() {
        try {
            AgenteCIA agenteCIA = new AgenteCIA("Joana", false);
            HumanoProxy humano = new HumanoProxy(2);

            humano.obterSenhas(agenteCIA);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Agente da CIA não identificado, saia imediatamente!", e.getMessage());
        }
    }
}
