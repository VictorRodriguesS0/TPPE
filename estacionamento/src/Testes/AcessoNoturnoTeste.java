package Testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

@Category(TesteFuncional.class)
@RunWith(Parameterized.class)
public class AcessoNoturnoTeste {

	Estacionamento estacionamento, estacionamento2, estacionamento3;
	Acesso acesso, acesso2, acesso3, acessoteste;
	private String tipoAcesso;
	private String placa;
	private String horaEntrada;
	private String horaSaida;
	float valorTotal;

	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"17-07-2022 07:00:00");
		acessoteste = new Acesso(placa, horaEntrada, horaSaida, estacionamento, tipoAcesso);

	}

	public AcessoNoturnoTeste(String placa, String horaEntrada, String horaSaida, float valorTotal) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.valorTotal = valorTotal;
	}

	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] respostas = new Object[][] { 
			{ "HI139", "16-07-2022 21:36:00", "17-07-2022 06:12:00", 21f },
			{ "HI138", "16-07-2022 21:00:00", "16-07-2022 22:00:00", 21f },
			{ "HI137", "16-07-2022 22:00:00", "16-07-2022 23:59:00", 21f }, 
			};

		return Arrays.asList(respostas);
	}

	@Test
	public void calculaValorAcessoNoturno() {
		float calculo = acessoteste.calculaAcesso();
		assertEquals(valorTotal, calculo, 0f);

	}

}
