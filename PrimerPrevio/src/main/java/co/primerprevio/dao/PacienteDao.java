package co.primerprevio.dao;

import co.primerprevio.model.Paciente;
import co.primerprevio.util.Conexion;

public class PacienteDao extends Conexion<Paciente>{

	public PacienteDao() {
		super(Paciente.class);
	}

}
