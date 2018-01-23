package br.com.viniciusgeraldoruas.myanimelist.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.springframework.stereotype.Component;

import br.com.viniciusgeraldoruas.myanimelist.modelo.Anime;
import br.com.viniciusgeraldoruas.myanimelist.modelo.Manga;

@Component
public class MALCliente {

	private String baseURL = "https://myanimelist.net/api/";
	
	HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("MALCliente", "clientemyanimelist");
	
	private Client client;
	
	public MALCliente() {
		this.client = ClientBuilder.newClient().register(feature);
	}

	public Anime pesquisaAnime(String title) {
		WebTarget target = client.target(baseURL + "anime/search.xml?q=" + title);
	    Anime anime = target.request().get(Anime.class);
		return anime;
	}
	
	public Manga pesquisaManga(String title) {
		WebTarget target = client.target(baseURL + "manga/search.xml?q=" + title);
		Manga manga = target.request().get(Manga.class);
		return manga;
	}
}
