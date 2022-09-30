package br.com.entra21.praticasql.Praticando.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.entra21.praticasql.Praticando.model.Exemplo;
import br.com.entra21.praticasql.Praticando.model.ItemNivel3;
import br.com.entra21.praticasql.Praticando.repository.IExemploRepository;

@RestController //dizendo que isso é um controller
@CrossOrigin(origins="*") //origens que podem utilizar esse controller, nesse caso, todas
@RequestMapping("/exemplos") //prefixo para todos os outros controllers
public class ExemploController {
	
	@Autowired // instancia essa variavel ao mesmo tempo que a classe controller inicializar
	private IExemploRepository exemploRepository; //chamando o repository para ter contato com o Banco de Dados
	
	@GetMapping()
	public List<Exemplo> listarAll(){
		
		return exemploRepository.findAll();
	}
	
	@GetMapping("/byAge/{age}")
	public List<Exemplo> getByAge(@PathVariable("age") Integer age){
		
		return exemploRepository.findByAge(age);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Exemplo adicionar(@RequestBody Exemplo novoExemplo) {

		return exemploRepository.save(novoExemplo);
	}
	
	@GetMapping("/nameeidade/{name}/{age}")
	public List<Exemplo> getByNameAndAge(@PathVariable("name") String name, @PathVariable("age") Integer age){
		
		return exemploRepository.findByFirstnameAndAge(name, age);
	}
	
	@GetMapping("/lessthanequalage/{age}")
	public List<Exemplo> getByAgeLessThanEqual(@PathVariable("age") Integer age){
		
		return exemploRepository.findByAgeLessThanEqual(age);
	}
	
	@GetMapping("/comecacom/{prefixo}")
	public List<Exemplo> getStartWith(@PathVariable("prefixo") String qualquer){
		
		return exemploRepository.findByLastnameStartingWith(qualquer);
	}
	
	private void setMaturidadeNivel3(Exemplo exemplo) {

		final String PATH = "localhost:8080/exemplo";
		//ObjectMapper mapper = new ObjectMapper(); // serializar e desarializar objetos
		//quebrar em pedaços e depois remontar, nesse caso, o JSON
		//transforma a representação do nosso objeto em String JSON
		//ele também faz o contrário
		//mapper.setSerializationInclusion(Include.NON_NULL);

		exemplo.getLinks().add(new ItemNivel3("GET", PATH));
        exemplo.getLinks().add(new ItemNivel3("GET", PATH + "/" + exemplo.getId()));
        exemplo.getLinks().add(new ItemNivel3("DELETE", PATH + "/" + exemplo.getId()));
        exemplo.getLinks().add(new ItemNivel3("POST", PATH));
        exemplo.getLinks().add(new ItemNivel3("PUT", PATH + "/" + exemplo.getId()));

	}
	
}
