package Estacionamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Exceptions.DescricaoEmBrancoException;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Acesso {
	String placa;
	String horaEntrada;
	String horaSaida;
	Estacionamento estacionamento;
	String tipoAcesso;
	
	public Acesso(String placa, String horaEntrada, String horaSaida, Estacionamento estacionamento, String tipoAcesso) throws DescricaoEmBrancoException{
		if (placa == null || placa.equals("")) {
			throw new DescricaoEmBrancoException("Dados da placa invalido");
		}
		if (horaEntrada == null || horaEntrada.equals("")) {
			throw new DescricaoEmBrancoException("Dados da hora de entrada invalidos");

		}
		if (horaSaida == null || horaSaida.equals("")) {
			throw new DescricaoEmBrancoException("Dados da hora de saída invalidos");

		}
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamento = estacionamento;
		this.tipoAcesso = tipoAcesso;
	}
	
	public float calculaAcesso() {
		
		if (tipoAcesso == "evento") {
			return estacionamento.valorEvento;
		}
		else if(tipoAcesso == "mensalista") {
			return estacionamento.valorMensalidade;
		}
		else {
			DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			
			LocalDateTime horaEntradaFormat = LocalDateTime.parse(this.horaEntrada, formatTime);
			LocalDateTime horaSaidaFormat = LocalDateTime.parse(this.horaSaida, formatTime);
			LocalDateTime inicioHoraNoturnaFormat = LocalDateTime.parse(this.estacionamento.inicioHoraNoturna, formatTime);
			
			float tempoPermanencia = horaEntradaFormat.until(horaSaidaFormat, MINUTES);
			int qtdFracoes = (int) Math.ceil(tempoPermanencia/15f);
			
			if(horaEntradaFormat.until(inicioHoraNoturnaFormat, MINUTES) <= 0) {
				return this.estacionamento.valorDiariaNoturna * this.estacionamento.valorDiariaDiurna;
			}
			else if (qtdFracoes < 4) {
				return this.estacionamento.valorFracao * qtdFracoes;
			}
			else if (qtdFracoes >= 4 && qtdFracoes <= 36) {
				return (this.estacionamento.valorFracao * qtdFracoes) * (1 - this.estacionamento.valorHoraCheia);
			}
			else {
				return this.estacionamento.valorDiariaDiurna;
			}
		}
	}
}
