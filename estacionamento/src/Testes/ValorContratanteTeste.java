package Testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Estacionamento.Acesso;
import Estacionamento.Estacionamento;

public class ValorContratanteTeste {
	
	Estacionamento estacionamento, estacionamento2, estacionamento3;
	ArrayList<Acesso> acessos = new ArrayList();
	ArrayList<Acesso> acessos2 = new ArrayList();
	ArrayList<Acesso> acessos3 = new ArrayList();
	
	

	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 20.0f, 0.10f, 70.0f, 0.30f, "16-07-2022 21:00:00",
				"17-07-2022 07:00:00", 600f, 50f, 0.60f);
		
		Acesso acessoEvento = new Acesso("HI139", "16-07-2022 21:36:00", "17-07-2022 06:12:00", estacionamento, "evento");
		Acesso acessoDiariaDiurna = new Acesso("HI138", "16-07-2022 08:00:00", "17-07-2022 18:00:00", estacionamento, null);
		Acesso acessoFracoes = new Acesso("HI137", "16-07-2022 08:00:00", "16-07-2022 08:45:00", estacionamento, null);
		acessos.add(acessoEvento);
		acessos.add(acessoDiariaDiurna);
		acessos.add(acessoFracoes);
		
		
		estacionamento2 = new Estacionamento("Estacionamento2", 30.0f, 0.15f, 120.0f, 0.45f, "16-07-2022 19:00:00",
				"17-07-2022 08:00:00", 455f, 50f, 0.50f);
		
		Acesso acessoEvento2 = new Acesso("HI139", "16-07-2022 09:00:00", "17-07-2022 10:00:00", estacionamento2, "evento");
		Acesso acessoDiariaDiurna2 = new Acesso("HI138", "16-07-2022 08:00:00", "17-07-2022 18:00:00", estacionamento2, null);
		Acesso acessoFracoes2 = new Acesso("HI137", "16-07-2022 08:00:00", "16-07-2022 08:45:00", estacionamento2, null);
		acessos2.add(acessoEvento2);
		acessos2.add(acessoDiariaDiurna2);
		acessos2.add(acessoFracoes2);
		
		estacionamento3 = new Estacionamento("Estacionamento3", 10.0f, 0.0f, 50.0f, 0.40f, "16-07-2022 20:00:00",
				"17-07-2022 08:00:00", 350f, 40f, 0.70f);
		
		Acesso acessoEvento3 = new Acesso("HI139", "16-07-2022 09:00:00", "16-07-2022 10:00:00", estacionamento3, "evento");
		Acesso acessoDiariaDiurna3 = new Acesso("HI138", "16-07-2022 08:00:00", "16-07-2022 18:00:00", estacionamento3, null);
		Acesso acessoFracoes3 = new Acesso("HI137", "16-07-2022 08:00:00", "16-07-2022 08:45:00", estacionamento3, null);
		acessos3.add(acessoEvento3);
		acessos3.add(acessoDiariaDiurna3);
		acessos3.add(acessoFracoes3);
		
	}

	@Test
	public void calculaValorContratante() {
		 float calcula = estacionamento.calcularContratante(acessos);
		 assertEquals(108, calcula, 0f);

	}
	
	@Test
	public void calculaValorContratanteDuplicada() {
		 float calcula = estacionamento2.calcularContratante(acessos2);
		 assertEquals(130, calcula, 0f);

	}

	
	@Test
	public void calculaValorContratanteTriplicada() {
		 float calcula = estacionamento3.calcularContratante(acessos3);
		 System.out.println(calcula);
		 assertEquals(84, calcula, 0f);

	}
	
}
