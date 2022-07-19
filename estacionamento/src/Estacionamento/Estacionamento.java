package Estacionamento;

import java.util.ArrayList;

import Exceptions.ValorAcessoInvalidoException;

public class Estacionamento {

	float valorFracao;
	float valorHoraCheia;
	float valorDiariaDiurna;
	float valorDiariaNoturna;
	float valorMensalidade;
	float valorEvento;
	String inicioFuncionamento;
	String fimFuncionamento;
	String inicioHoraNoturna;
	String fimHoraNoturna;
	int capacidade;
	float retornoContratante;
	int numeroAcessos;
	float valorApurado;
	String nomeEstacionamento;

	public Estacionamento(float valorFracao, float valorHoraCheia, float valorDiariaDiurna, float valorDiariaNoturna,
			float valorMensalidade, float valorEvento, String inicioFuncionamento, String fimFuncionamento,
			int capacidade, float retornoContratante, int numeroAcessos, float valorApurado,
			String nomeEstacionamento) throws ValorAcessoInvalidoException {
		
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
		if(valorDiariaDiurna < 0) {
			throw new ValorAcessoInvalidoException("Valor de diária diurna inválido");
		}
		
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.valorDiariaNoturna = valorDiariaNoturna;
		this.valorMensalidade = valorMensalidade;
		this.valorEvento = valorEvento;
		this.inicioFuncionamento = inicioFuncionamento;
		this.fimFuncionamento = fimFuncionamento;
		this.capacidade = capacidade;
		this.retornoContratante = retornoContratante;
		this.numeroAcessos = numeroAcessos;
		this.valorApurado = valorApurado;
		this.nomeEstacionamento = nomeEstacionamento;
	}

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, float valorDiariaDiurna,
			float porcentagemDiariaNoturna, String inicioHoraNoturna, String fimHoraNoturna) throws ValorAcessoInvalidoException {
		this.nomeEstacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.valorDiariaNoturna = porcentagemDiariaNoturna;
		this.inicioHoraNoturna = inicioHoraNoturna;
		this.fimHoraNoturna = fimHoraNoturna;
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
		if(valorDiariaDiurna < 0) {
			throw new ValorAcessoInvalidoException("Valor de diária diurna inválido");
		}
	}

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia) throws ValorAcessoInvalidoException {
		this.nomeEstacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
	}

	public Estacionamento(float valorFracao, float valorHoraCheia, float valorDiariaDiurna, float valorDiariaNoturna,
			float valorMensalidade, float valorEvento, String inicioHoraNoturna, String fimHoraNoturna, int capacidade,
			float retornoContratante, String nomeEstacionamento) throws ValorAcessoInvalidoException {
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.valorDiariaNoturna = valorDiariaNoturna;
		this.valorMensalidade = valorMensalidade;
		this.valorEvento = valorEvento;
		this.inicioHoraNoturna = inicioHoraNoturna;
		this.fimHoraNoturna = fimHoraNoturna;
		this.capacidade = capacidade;
		this.retornoContratante = retornoContratante;
		this.nomeEstacionamento = nomeEstacionamento;
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
		if(valorDiariaDiurna < 0) {
			throw new ValorAcessoInvalidoException("Valor de diária diurna inválido");
		}
	}

	public Estacionamento(float valorFracao, float valorHoraCheia, String nomeEstacionamento) throws ValorAcessoInvalidoException {
		super();
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.nomeEstacionamento = nomeEstacionamento;
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
	}

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, float valorDiariaDiurna,
			float valorDiariaNoturna, String inicioHoraNoturna, String fimHoraNoturna, float valorMensalidade,
			float valorEvento, float retornoContratante) throws ValorAcessoInvalidoException {
		super();
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.valorDiariaNoturna = valorDiariaNoturna;
		this.valorMensalidade = valorMensalidade;
		this.valorEvento = valorEvento;
		this.inicioHoraNoturna = inicioHoraNoturna;
		this.fimHoraNoturna = fimHoraNoturna;
		this.retornoContratante = retornoContratante;
		this.nomeEstacionamento = nomeEstacionamento;
		if(valorFracao < 0) {
			throw new ValorAcessoInvalidoException("Valor de fração inválido");
		}
		if(valorHoraCheia < 0) {
			throw new ValorAcessoInvalidoException("Valor de Hora Cheia inválido");
		}
		if(valorDiariaDiurna < 0) {
			throw new ValorAcessoInvalidoException("Valor de diária diurna inválido");
		}
	}

	public float calcularContratante(ArrayList<Acesso> listaAcessos) {
		float total = 0;
		for (Acesso acesso : listaAcessos) {
			total = total + (acesso.calculaAcesso() * retornoContratante);
		}
		return total;
	}

}