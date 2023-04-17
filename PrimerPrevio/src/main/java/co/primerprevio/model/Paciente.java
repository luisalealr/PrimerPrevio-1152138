package co.primerprevio.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the paciente database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="paciente_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paciente_id_sequence")
	private Integer id;

	private String apellido;

	@Transient
	private String contextura;

	private String direccion;

	private String documento;

	private String email;

	private BigDecimal estatura;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String genero;

	private String nombre;

	private BigDecimal peso;

	private String telefono;
	
	@Transient
	private Integer IMC;

	public Paciente(String apellido, String direccion, String documento, String email, BigDecimal estatura,
			Date fechanacimiento, String genero, String nombre, BigDecimal peso, String telefono) {
		super();
		this.apellido = apellido;
		this.direccion = direccion;
		this.documento = documento;
		this.email = email;
		this.estatura = estatura;
		this.fechanacimiento = fechanacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.peso = peso;
		this.telefono = telefono;
	}

	public Paciente(Integer id, String apellido, String direccion, String documento, String email, BigDecimal estatura,
			Date fechanacimiento, String genero, String nombre, BigDecimal peso, String telefono) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.direccion = direccion;
		this.documento = documento;
		this.email = email;
		this.estatura = estatura;
		this.fechanacimiento = fechanacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.peso = peso;
		this.telefono = telefono;
	}

}