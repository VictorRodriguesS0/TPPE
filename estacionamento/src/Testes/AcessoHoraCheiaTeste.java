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
import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorAcessoInvalidoException;

@Category(TesteFuncional.class)
@RunWith(Parameterized.class)
public class AcessoHoraCheiaTeste {

	Estacionamento estacionamento;
	Acesso acesso, acessoteste;
	Acesso acesso2;
	Acesso acesso3;
	private String tipoAcesso;
	private String placa;
	private String horaEntrada;
	private String horaSaida;
	float valorTotal;

	@Before
	public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		estacionamento = new Estacionamento("Estacionamento2", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"16-07-2022 07:00:00");
		acessoteste = new Acesso(placa, horaEntrada, horaSaida, estacionamento, tipoAcesso);

	}

	public AcessoHoraCheiaTeste(String placa, String horaEntrada, String horaSaida, float valorTotal) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.valorTotal = valorTotal;
	}

	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] respostas = new Object[][] { { "HI139", "16-07-2022 08:30:00", "16-07-2022 09:30:00", 72f },
				{ "HI138", "16-07-2022 15:12:00", "16-07-2022 16:12:00", 72f },
				{ "HI137", "16-07-2022 21:36:00", "17-07-2022 06:12:00", 21f }, };

		return Arrays.asList(respostas);
	}

	@Test
	public void calculaValorAcessoHoraCheia() {
		float calculo = acessoteste.calculaAcesso();
		assertEquals(valorTotal, calculo, 0f);

	}

}