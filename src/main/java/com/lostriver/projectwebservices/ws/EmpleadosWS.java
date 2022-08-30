/**
 * 
 */
package com.lostriver.projectwebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.lostriver.projectwebservices.entity.Empleado;
import com.lostriver.projectwebservices.service.EmpleadoService;

/**
 * @author lostriver WebService generat per Jersey
 *
 */
@Path("empleadosWS")
public class EmpleadosWS {

	private EmpleadoService empleadoService = new EmpleadoService();

	@GET
	@Path("test")
	public String test() {

		return "provant webservice amb Jersey";

	}

	@GET
	@Path("consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {

		return this.empleadoService.consultarEmpleado();

	}

	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados() {

		return this.empleadoService.consultarEmpleados();

	}

	@GET
	@Path("consultarEmpleadosPorNumeroEmpleado/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp") String numeroEmpleado) {

		Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numeroEmpleado);

	    if(empleadoConsultado == null) {
	    	
	    	return Response.noContent().build();
	    }
	    
	    GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado,Empleado.class);
	    return Response.ok(empleadoGeneric).build();
	}
	
	@POST
	@Path("guardarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado){

		if(empleado == null ) {
			return Response.status(400).entity("No hi ha informació del treballador, per favor omple les seves dades").build();
		}
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty()){
			
			return Response.status(400).entity("El nom es obligatori").build();
			
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado,Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}

}
