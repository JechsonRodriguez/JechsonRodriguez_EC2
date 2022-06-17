package com.idat.ec2JechsonRodriguez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2JechsonRodriguez.dto.UsuarioReq;
import com.idat.ec2JechsonRodriguez.dto.UsuarioRes;
import com.idat.ec2JechsonRodriguez.modelo.Usuario;
import com.idat.ec2JechsonRodriguez.repositorio.UsuarioRepositorio;
import com.idat.ec2JechsonRodriguez.utilitarios.ModelMapperConfig;

@Service
public class UsuarioServImpl implements UsuarioServ {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private ModelMapperConfig mapper;
	
	@Override
	public void registrar(UsuarioReq user) {
		Usuario u = mapper.modelMapper().map(user, Usuario.class);
		repositorio.save(u);
	}

	@Override
	public void editar(UsuarioReq user) {
		Usuario u = mapper.modelMapper().map(user, Usuario.class);
		repositorio.saveAndFlush(u);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public UsuarioRes obtenerId(int id) {
		Usuario u = repositorio.findById(id).orElse(null);
		UsuarioRes res = new UsuarioRes();
		if (u!=null) {
			res = mapper.modelMapper().map(u, UsuarioRes.class);
		}
		return res;
	}

	@Override
	public List<UsuarioRes> listar() {
		List<UsuarioRes> res = new ArrayList<UsuarioRes>();
		List<Usuario> u = repositorio.findAll();
		if (u!=null) {
			for (Usuario usuario : u) {
				UsuarioRes r = new UsuarioRes();
				r = mapper.modelMapper().map(usuario, UsuarioRes.class);
				res.add(r);
			}
		}
		return res;
	}

}
