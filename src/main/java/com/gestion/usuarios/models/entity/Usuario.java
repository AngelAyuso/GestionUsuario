package com.gestion.usuarios.models.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = -3497786412530852467L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuario")
	private int idUsuario;
	private String password;
	private String nombre;
	@Column(name="primerapellido")
	private String primerApellido;
	@Column(name="segundoapellido")
	private String segundoApellido;
	@Column(unique = true)
	private String email;
	private int telefono;
	@Column(unique = true)
	private String dni;
	@Column(name="fechaalta")
	private String fechaAlta;
	@Column(name="fechamodificacion")
	private String fechaModificacion;
	private String enabled;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_to_rol", joinColumns = @JoinColumn(name = "id_usuario"),
	inverseJoinColumns = @JoinColumn(name = "id_rol"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario","id_rol"})})
	private List<Rol> roles;
	
	public Usuario() {
	}
	
	public Usuario(int idUsuario, String password, String nombre, String primerApellido, 
					String segundoApellido, String email, int telefono, String dni, String fechaAlta, String fechaModificacion,
					String enabled) {
		super();
		this.idUsuario = idUsuario;
		this.password = password;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
		this.fechaModificacion = fechaModificacion;
		this.enabled = enabled;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	public String toString() {
        return String.format("idUsuario:"+idUsuario+"-nombre:"+nombre+"-primerApellido:"+primerApellido+"-segundoApellido:"+segundoApellido+
        		"-email:"+email+"-telefono:"+telefono+"-dni:"+dni+"-fechaAlta:"+fechaAlta+"-fechaModificacion:"+fechaModificacion+"-enabled:"+enabled);
    }
}