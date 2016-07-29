package br.com.polovinskycode.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {
	
	@Test
	public void deveRetornarMaiorLance() {
		
		Leilao leilao = new Leilao("Macbook Pro 15");
		
		Lance lance = new Lance(new Usuario("Joao"), 1000.0);
		Lance lance1 = new Lance(new Usuario("Jose"), 2000.0);
		
		leilao.propoe(lance1);
		leilao.propoe(lance);
		
		Avaliador avalia = new Avaliador();
		avalia.avalia(leilao);
		
		double maiorLance  = 2000.0;
		
		Assert.assertEquals(maiorLance, avalia.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void deveRetornarMenorLance() {
		
		Leilao leilao = new Leilao("Macbook Pro 15");
		
		Lance lance = new Lance(new Usuario("Joao"), 1000.0);
		Lance lance1 = new Lance(new Usuario("Jose"), 2000.0);
		
		leilao.propoe(lance1);
		leilao.propoe(lance);
		
		Avaliador avalia = new Avaliador();
		avalia.avalia(leilao);
		
		double maiorLance  = 1000.0;
		
		Assert.assertEquals(maiorLance, avalia.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveRetornaMenorAndMaiorLanceComMesmoResultado() throws Exception {
		
		Leilao leilao = new Leilao("Macbook Pro 15");
		
		Lance lance = new Lance(new Usuario("Joao"), 1000.0);
		
		leilao.propoe(lance);
		
		Avaliador avalia = new Avaliador();
		avalia.avalia(leilao);
		
		double maiorLance  = 1000.0;
		double menorLance  = 1000.0;
		
		Assert.assertEquals(maiorLance, avalia.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorLance, avalia.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveRetornarOs3MaioresLances() throws Exception {
		
		
		Leilao leilao = new Leilao("Car");
		
		Lance lance = new Lance(new Usuario("Pedro"), 2000.0);
		Lance lance1 = new Lance(new Usuario("Maria"), 3000.0);
		Lance lance2 = new Lance(new Usuario("Tiago"), 4000.0);
		Lance lance3 = new Lance(new Usuario("Lucas"), 5000.0);
		
		
		Avaliador avalia = new Avaliador();
		leilao.propoe(lance);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		avalia.avalia(leilao);
		
		Assert.assertEquals(3, avalia.getTresMaioresLances().size());
		Assert.assertEquals(5000.0, avalia.getTresMaioresLances().get(0).getValor(), 0.00001);
		Assert.assertEquals(4000.0, avalia.getTresMaioresLances().get(1).getValor(), 0.00001);
		Assert.assertEquals(3000.0, avalia.getTresMaioresLances().get(2).getValor(), 0.00001);
	}
	
	
	
}
