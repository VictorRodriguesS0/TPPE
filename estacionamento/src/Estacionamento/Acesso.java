package Estacionamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorAcessoInvalidoException;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Acesso {
	String placa;
	String horaEntrada;
	String horaSaida;
	Estacionamento estacionamento;
	String tipoAcesso;

	private static final DateTimeFormatter FORMATTIME = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final float FRACAO15MINUTOS = 15f;
	private static final int FRACOES1HORA = 4;
	private static final int FRACOES9HORA = 36;

	
	public Acesso(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento, String tipoAcesso) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		validatePlaca(placa);
		validateEntrada(horaEntrada);
		validateSaida(horaSaida);
		
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamento = estacionamento;
		this.tipoAcesso = tipoAcesso;
	}

	public void validateSaida(String horaSaida) throws DescricaoEmBrancoException {
		if (horaSaida == null || horaSaida.equals("")) {
			throw new DescricaoEmBrancoException("Dados da hora de saída invalidos");

		}
	}

	public void validateEntrada(String horaEntrada) throws DescricaoEmBrancoException {
		if (horaEntrada == null || horaEntrada.equals("")) {
			throw new DescricaoEmBrancoException("Dados da hora de entrada invalidos");

		}
	}

	public void validatePlaca(String placa) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
			throw new DescricaoEmBrancoException("Dados da placa invalido");
		}
	}
	
	public float calculaAcesso() {
		
		if (tipoAcesso == "evento") {
			return estacionamento.valorEvento;
		}
		else if(tipoAcesso == "mensalista") {
			return estacionamento.valorMensalidade;
		}
		else {

			LocalDateTime horaEntradaFormat = LocalDateTime.parse(this.horaEntrada, FORMATTIME);
			LocalDateTime horaSaidaFormat = LocalDateTime.parse(this.horaSaida, FORMATTIME);
			LocalDateTime inicioHoraNoturnaFormat = LocalDateTime.parse(this.estacionamento.inicioHoraNoturna, FORMATTIME);
			
			float tempoPermanencia = horaEntradaFormat.until(horaSaidaFormat, MINUTES);
			int qtdFracoes = (int) Math.ceil(tempoPermanencia/FRACAO15MINUTOS);
			
			if(horaEntradaFormat.until(inicioHoraNoturnaFormat, MINUTES) <= 0) {
				return this.estacionamento.valorDiariaNoturna * this.estacionamento.valorDiariaDiurna;
			}
			else if (qtdFracoes < FRACOES1HORA) {
				return this.estacionamento.valorFracao * qtdFracoes;
			}
			else if (qtdFracoes >= FRACOES1HORA && qtdFracoes <= FRACOES9HORA) {
				return (this.estacionamento.valorFracao * qtdFracoes) * (1 - this.estacionamento.valorHoraCheia);
			}
			else {
				return this.estacionamento.valorDiariaDiurna;
			}
		}
	}
}
