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
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String apellido;

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

	public Paciente(String apellido, String contextura, String direccion, String documento, String email,
			BigDecimal estatura, Date fechanacimiento, String genero, String nombre, BigDecimal peso, String telefono) {
		super();
		this.apellido = apellido;
		this.contextura = contextura;
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