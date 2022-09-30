package br.com.entra21.praticasql.Praticando.model;

public class ItemNivel3 {

	//isso vai auxiliar o frontend a saber de onde veio as informações
	//no caso as requisições da API
	private String ref; //referencia
	private String url;	//url
	
	public ItemNivel3() {
		super();
	}

	public ItemNivel3(String ref, String url) {
		super();
		this.ref = ref;
		this.url = url;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
