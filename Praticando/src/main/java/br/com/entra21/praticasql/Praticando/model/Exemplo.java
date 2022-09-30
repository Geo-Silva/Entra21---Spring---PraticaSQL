package br.com.entra21.praticasql.Praticando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="exemplo") //nome da tabela lá no Banco de Dados
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //estrategia de herança, como será manipulado.
//Nesse caso, tabela por classe. Criando uma tabela por classe lá no Banco de Dados, sendo separadas
public class Exemplo extends MaturidadeNivel3{
	
	//as Annotations são aplicadas sempre na primeira variável abaixo delas, nesse caso, a ID
	@Id //dizendo que a variável "id" é uma PrimaryKey (PK), NotNull (NN) e Unique (UQ)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //dizendo que a PK é AutoIncrement (AI)
	private Integer id; // <---- Annotations serão aplicadas aqui 
	private String firstname; // <---- Mas aqui não
	private String lastname;
	private Integer age; 
	private Boolean active;
	
	public Exemplo() {
		super();
	}

	public Exemplo(Integer id, String firstname, String lastname, Integer age, Boolean active) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
