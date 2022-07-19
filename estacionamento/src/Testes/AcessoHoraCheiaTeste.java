package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

public class AcessoHoraCheiaTeste {

	Estacionamento estacionamento;
	Acesso acesso;
	Acesso acesso2;
	Acesso acesso3;
	private String tipoAcesso;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento2", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"16-07-2022 07:00:00");
		acesso = new Acesso("HI139", "16-07-2022 08:30:00", "16-07-2022 09:30:00", estacionamento, tipoAcesso);
		acesso2 = new Acesso("HI138", "16-07-2022 08:00:00", "16-07-2022 10:00:00", estacionamento, tipoAcesso);
		acesso3 = new Acesso("HI137", "16-07-2022 08:00:00", "16-07-2022 11:00:00", estacionamento, tipoAcesso);
		
	}
	
	@Test
	public void calculaValorAcessoHoraCheia() {
		float calcula = acesso.calculaAcesso();
		assertEquals(72, calcula, 0f);

	}
	
	@Test
	public void calculaValorAcessoHoraCheiaDuplicada() {
		float calcula = acesso2.calculaAcesso();
		assertEquals(144, calcula, 0f);

	}
	
	@Test
	public void calculaValorAcessoHoraCheiaTriplicada() {
		float calcula = acesso3.calculaAcesso();
		assertEquals(216, calcula, 0f);

	}


}