package br.com.entra21.praticasql.Praticando.model;

import java.util.ArrayList;

public class MaturidadeNivel3 {
	
	//criando a lista
	ArrayList<ItemNivel3> links;
	
	//inicializando a lista
	public MaturidadeNivel3() {
		this.links = new ArrayList<>();
	}
	
	//aqui vai receber os valores de fora
	public MaturidadeNivel3(ArrayList<ItemNivel3> links) {
		super();
		this.links = links;
	}
	
	//Get e Set
	public ArrayList<ItemNivel3> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<ItemNivel3> links) {
		this.links = links;
	}
	
}
