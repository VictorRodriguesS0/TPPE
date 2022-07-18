package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

public class AcessoNoturnoTeste {
	
	Estacionamento estacionamento;
	Acesso acesso;
	private String tipoAcesso;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento2", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"16-07-2022 07:00:00");
		acesso = new Acesso("HI139", "16-07-2022 21:36:00", "17-07-2022 06:12:00", estacionamento, tipoAcesso);
		
	}
	
	@Test
	public void calculaValorAcessoNoturno() {
		float calcula = acesso.calculaAcesso();
		assertEquals(21, calcula, 0f);

	}
	

}
