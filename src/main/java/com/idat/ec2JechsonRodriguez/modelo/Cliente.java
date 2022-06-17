package com.idat.ec2JechsonRodriguez.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String direccion;
	private String dni;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Cliente() {
	}
	
	
	public Cliente(int idCliente, String nombre, String direccion, String dni, Set<Producto> cliente_productos) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.cliente_productos = cliente_productos;
	}



	@ManyToMany(mappedBy = "clientes")
	private Set<Producto> cliente_productos= new HashSet<>();
	public Set<Producto> getCliente_productos() {
		return cliente_productos;
	}
	public void setCliente_productos(Set<Producto> cliente_productos) {
		this.cliente_productos = cliente_productos;
	}
	
	
	
	
}
