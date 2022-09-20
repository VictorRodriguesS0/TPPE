package Estacionamento;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalcularAcesso {

	private static final DateTimeFormatter FORMATTERTIME = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	private static final float FRACAO15MINUTOS = 15f;
	private static final int FRACOES1HORA = 4;
	private static final int FRACOES9HORA = 36;

	private LocalDateTime horaEntradaFormat;
	private LocalDateTime horaSaidaFormat;

	private float tempoPermanencia;
	private int qtdFracoes;

	public CalcularAcesso(String horaEntrada, String horaSaida) {
		this.horaEntradaFormat = LocalDateTime.parse(horaEntrada, FORMATTERTIME);
		this.horaSaidaFormat = LocalDateTime.parse(horaSaida, FORMATTERTIME);
		this.tempoPermanencia = horaEntradaFormat.until(horaSaidaFormat, MINUTES);
		this.qtdFracoes = (int) Math.ceil(tempoPermanencia / FRACAO15MINUTOS);
	}

	public float calculaAcesso(Estacionamento estacionamento) {
		// Função que calcula o valor de acesso e permanência dos veiculos no
		// estacionamento

		LocalDateTime inicioHoraNoturnaFormat = LocalDateTime.parse(estacionamento.inicioHoraNoturna, FORMATTERTIME);

		if (horaEntradaFormat.until(inicioHoraNoturnaFormat, MINUTES) <= 0) {
			return estacionamento.valorDiariaNoturna * estacionamento.valorDiariaDiurna;
		}

		else if (qtdFracoes < FRACOES1HORA) {
			return estacionamento.valorFracao * qtdFracoes;
		} else if (qtdFracoes >= FRACOES1HORA && qtdFracoes <= FRACOES9HORA) {
			return (estacionamento.valorFracao * qtdFracoes) * (1 - estacionamento.valorHoraCheia);
		} else {
			return estacionamento.valorDiariaDiurna;
		}
	}

}
