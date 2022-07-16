package Estacionamento;

import java.util.ArrayList;

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
			String nomeEstacionamento) {
		super();
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
			float porcentagemDiariaNoturna, String inicioHoraNoturna, String fimHoraNoturna) {
		this.nomeEstacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.valorDiariaNoturna = porcentagemDiariaNoturna;
		this.inicioHoraNoturna = inicioHoraNoturna;
		this.fimHoraNoturna = fimHoraNoturna;
	}

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia) {
		this.nomeEstacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
	}

	public float calcularContratante(ArrayList<Acesso> listaAcessos) {
		float total = 0;
		for (Acesso acesso : listaAcessos) {
			total = total + (acesso.calculaAcesso() * retornoContratante);
		}
		return total;
	}

}