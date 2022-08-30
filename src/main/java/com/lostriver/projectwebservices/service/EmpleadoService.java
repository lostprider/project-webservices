/**
 * 
 */
package com.lostriver.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lostriver.projectwebservices.entity.Empleado;

/**
 * @author lostriver
 *
 */
public class EmpleadoService {
	
	/**
	 * Metode que permet consultar un treballador per la seva id
	 * @param numeroEmpleado {@link String} numero del treballador.
	 * @return {@link Empleado} treballador consultat.
	 */

	public Empleado consultarEmpleadoPorNumeroEmpleado(String numeroEmpleado) {

		List<Empleado> empleadosConsultados = this.consultarEmpleados();

		for (Empleado empleadoConsultado : empleadosConsultados) {
			if (empleadoConsultado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleadoConsultado;

			}

		}
		return null;
	}

	/**
	 * Metode que simula la consulta d'un treballador
	 * 
	 * @return {@link Empleado} consultar treballador
	 */
	public Empleado consultarEmpleado() {

		Empleado empleado = new Empleado();

		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Albert");
		empleado.setPrimerApellido("Pérez");
		empleado.setSegundoApellido("Sahún");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(37);

		return empleado;

	};

	public List<Empleado> consultarEmpleados() {

		List<Empleado> empleados = new ArrayList();

		Empleado empleado = new Empleado();

		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Albert");
		empleado.setPrimerApellido("Pérez");
		empleado.setSegundoApellido("Sahún");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(37);

		Empleado empleadoNuevo = new Empleado();

		empleadoNuevo.setNumeroEmpleado("458756");
		empleadoNuevo.setNombre("Robert");
		empleadoNuevo.setPrimerApellido("Pérez");
		empleadoNuevo.setSegundoApellido("Sahún");
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		empleadoNuevo.setEdad(34);

		empleados.add(empleado);
		empleados.add(empleadoNuevo);

		return empleados;

	}

}
