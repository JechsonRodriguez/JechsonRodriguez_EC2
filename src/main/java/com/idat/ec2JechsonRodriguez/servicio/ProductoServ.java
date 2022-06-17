package com.idat.ec2JechsonRodriguez.servicio;

import java.util.List;

import com.idat.ec2JechsonRodriguez.dto.ProductoReq;
import com.idat.ec2JechsonRodriguez.dto.ProductoRes;


public interface ProductoServ {

	public void registrar(ProductoReq pro);
	public void editar(ProductoReq pro);
	public void eliminar(int id);
	public ProductoRes obtenerId(int id);
	public List<ProductoRes> listar();
}
