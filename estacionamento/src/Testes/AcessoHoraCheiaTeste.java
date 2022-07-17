package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Estacionamento;

public class AcessoHoraCheiaTeste {

	Estacionamento estacionamento;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f);
	}
	
	@Test
	public void calculaValorAcessoHoraCheia() {
		int valorAcesso = estacionamento.calculaAcesso("Estacionamento1", "8:30", "9:30");
		assertEquals(valorAcesso, 100);

	}

}