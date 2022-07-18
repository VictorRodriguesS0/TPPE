package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

public class AcessoNoturnoTeste {

	Estacionamento estacionamento, estacionamento2;
	Acesso acesso, acesso2;
	private String tipoAcesso;

	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"16-07-2022 07:00:00");
		estacionamento2 = new Estacionamento("Estacionamento2", 30.0f, 0.15f, 120.0f, 0.45f, "16-07-2022 19:00:00",
				"16-07-2022 08:00:00");
		acesso = new Acesso("HI139", "16-07-2022 21:36:00", "17-07-2022 06:12:00", estacionamento, tipoAcesso);
		acesso2 = new Acesso("HI138", "16-07-2022 21:00:00", "16-07-2022 22:00:00", estacionamento2, tipoAcesso);

	}

	@Test
	public void calculaValorAcessoNoturno() {
		float calcula = acesso.calculaAcesso();
		assertEquals(21, calcula, 0f);

	}

	@Test
	public void calculaValorAcessoNoturno2() {
		float calcula2 = acesso2.calculaAcesso();
		assertEquals(54, calcula2, 0f);

	}

}
