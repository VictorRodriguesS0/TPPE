package Testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

public class ValorContratanteTeste {
	
	Estacionamento estacionamento, estacionamento2, estacionamento3;
	ArrayList<Acesso> acessos = new ArrayList();
	
	

	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"17-07-2022 07:00:00", 600f, 50f, 0.60f);
		
		Acesso acessoEvento = new Acesso("HI139", "16-07-2022 21:36:00", "17-07-2022 06:12:00", estacionamento, "evento");
		Acesso acessoDiariaDiurna = new Acesso("HI138", "16-07-2022 08:00:00", "17-07-2022 18:00:00", estacionamento, null);
		Acesso acessoFracoes = new Acesso("HI137", "16-07-2022 08:00:00", "17-07-2022 08:45:00", estacionamento, null);
		acessos.add(acessoEvento);
		acessos.add(acessoDiariaDiurna);
		acessos.add(acessoFracoes);
		
	}

	@Test
	public void calculaValorContratante() {
		 float calcula = estacionamento.calcularContratante(acessos);
		 assertEquals(114, calcula, 0f);

	}

}
