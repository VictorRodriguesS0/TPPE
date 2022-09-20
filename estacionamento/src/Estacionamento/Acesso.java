package Estacionamento;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorAcessoInvalidoException;

public class Acesso {
	String placa;
	String horaEntrada;
	String horaSaida;
	Estacionamento estacionamento;
	String tipoAcesso;
	
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
		// Função que retorna o valor do estacionamento refente ao tipo de acesso realizado
		if (tipoAcesso == "evento") {
			return estacionamento.valorEvento;
		}
		else if(tipoAcesso == "mensalista") {
			return estacionamento.valorMensalidade;
		}
		else {
			
			CalcularAcesso calcula = new CalcularAcesso(this.horaEntrada, this.horaSaida);
			return calcula.calculaAcesso(this.estacionamento);

		}
	}
}
