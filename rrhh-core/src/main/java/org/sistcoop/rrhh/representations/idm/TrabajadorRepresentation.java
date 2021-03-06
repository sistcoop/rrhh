package org.sistcoop.rrhh.representations.idm;

import java.io.Serializable;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;

public class TrabajadorRepresentation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String tipoDocumento;
	private String numeroDocumento;	

	private String usuario;

	private AgenciaRepresentation agencia;
	private AreaRepresentation area;
	private CargoRepresentation cargo;

	@Size(min = 1)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Size(min = 1, max = 20)
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Size(min = 1, max = 20)
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Size(min = 1, max = 60)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@XmlElement
	public AgenciaRepresentation getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaRepresentation agencia) {
		this.agencia = agencia;
	}

	@XmlElement
	public AreaRepresentation getArea() {
		return area;
	}

	public void setArea(AreaRepresentation area) {
		this.area = area;
	}

	@XmlElement
	public CargoRepresentation getCargo() {
		return cargo;
	}

	public void setCargo(CargoRepresentation cargo) {
		this.cargo = cargo;
	}

}