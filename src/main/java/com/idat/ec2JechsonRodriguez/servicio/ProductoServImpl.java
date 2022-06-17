package com.idat.ec2JechsonRodriguez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2JechsonRodriguez.dto.ProductoReq;
import com.idat.ec2JechsonRodriguez.dto.ProductoRes;
import com.idat.ec2JechsonRodriguez.modelo.Producto;
import com.idat.ec2JechsonRodriguez.repositorio.ProductoRepositorio;
import com.idat.ec2JechsonRodriguez.utilitarios.ModelMapperConfig;

@Service
public class ProductoServImpl implements ProductoServ {

	@Autowired
	private ProductoRepositorio repositorio;

	@Autowired
	private ModelMapperConfig mapper;

	@Override
	public void registrar(ProductoReq pro) {
		Producto p = mapper.modelMapper().map(pro, Producto.class);
		repositorio.save(p);
	}

	@Override
	public void editar(ProductoReq pro) {
		Producto p = mapper.modelMapper().map(pro, Producto.class);
		repositorio.saveAndFlush(p);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public ProductoRes obtenerId(int id) {
		Producto p = repositorio.findById(id).orElse(null);
		ProductoRes res = new ProductoRes();
		if (p!=null) {
			res = mapper.modelMapper().map(p, ProductoRes.class);
		}
		return res;
	}

	@Override
	public List<ProductoRes> listar() {
		List<ProductoRes> res = new ArrayList<ProductoRes>();
		List<Producto> p = repositorio.findAll();
		if (p!=null) {
			for (Producto producto : p) {
				ProductoRes r = new ProductoRes();
				r = mapper.modelMapper().map(producto, ProductoRes.class);
				res.add(r);
			}
		}
		return res;
	}
	
	

}
