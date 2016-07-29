package br.com.polovinskycode.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores = new ArrayList<>();

	public void avalia(Leilao leilao) {
		for (Lance lances : leilao.getLances()) {
			if (lances.getValor() > maiorDeTodos) {
				maiorDeTodos = lances.getValor();
			}

			if (lances.getValor() < menorDeTodos) {
				menorDeTodos = lances.getValor();
			}
		}
		
		maiores = new ArrayList<>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {

			@Override
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor()) {
					return 1;
				}
				if (o1.getValor() > o2.getValor()) {
					return -1;
				}
				return 0;
			}
		});
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public List<Lance> getTresMaioresLances() {
		return maiores.subList(0, 3);
	}
}
