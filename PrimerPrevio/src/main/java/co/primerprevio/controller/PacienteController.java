package co.primerprevio.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.primerprevio.dao.PacienteDao;
import co.primerprevio.model.Paciente;

@WebServlet("/")
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDao pDao;

	public PacienteController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		this.pDao = new PacienteDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarUsuario(request, response);
				break;
			case "/delete":
				eliminarUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarUsuario(request, response);
				break;
			default:
				listUsuarios(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}

	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		BigDecimal peso = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));
		BigDecimal estatura = BigDecimal.valueOf(Double.parseDouble(request.getParameter(("estatura"))));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechanacimiento = formato.parse(request.getParameter("fechanacimiento"));
		String telefono = request.getParameter("telefono");
		Paciente paciente = new Paciente(apellido, direccion, documento, email, estatura, fechanacimiento,
				genero, nombre, peso, telefono);
		pDao.insert(paciente);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente pacienteActual = pDao.find(id);
		request.setAttribute("paciente", pacienteActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		BigDecimal peso = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));
		BigDecimal estatura = BigDecimal.valueOf(Double.parseDouble(request.getParameter(("estatura"))));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date fechanacimiento = formato.parse(request.getParameter("fechanacimiento"));
		String telefono = request.getParameter("telefono");
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente paciente = new Paciente(id, apellido, direccion, documento, email, estatura, fechanacimiento,
				genero, nombre, peso, telefono);
		pDao.update(paciente);
		response.sendRedirect("list");
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente pacienteActual = pDao.find(id);
		pDao.delete(pacienteActual);
		response.sendRedirect("list");
	}

	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Paciente> listPacientes = pDao.list();
		request.setAttribute("listPacientes", listPacientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacientelist.jsp");
		dispatcher.forward(request, response);
	}

	private int getImc(HttpServletRequest request, HttpServletResponse response) {
		int peso = Integer.parseInt(request.getParameter("peso"));
		int estatura = Integer.parseInt(request.getParameter("estatura"));
		return peso/estatura;
	}

}
