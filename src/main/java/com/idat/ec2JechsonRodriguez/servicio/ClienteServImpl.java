package com.idat.ec2JechsonRodriguez.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2JechsonRodriguez.dto.ClienteReq;
import com.idat.ec2JechsonRodriguez.dto.ClienteRes;
import com.idat.ec2JechsonRodriguez.modelo.Cliente;
import com.idat.ec2JechsonRodriguez.repositorio.ClienteRepositorio;
import com.idat.ec2JechsonRodriguez.utilitarios.ModelMapperConfig;

@Service
public class ClienteServImpl implements ClienteServ {

	@Autowired
	private ClienteRepositorio repositorio;
	
	@Autowired
	private ModelMapperConfig mapper;
	
	
	@Override
	public void registrar(ClienteReq cli) {
		Cliente c = mapper.modelMapper().map(cli, Cliente.class);
		repositorio.save(c);
	}

	@Override
	public void editar(ClienteReq cli) {
		Cliente c = mapper.modelMapper().map(cli, Cliente.class);
		repositorio.saveAndFlush(c);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public ClienteRes obtenerId(int id) {
		Cliente c = repositorio.findById(id).orElse(null);
		ClienteRes res = new ClienteRes();
		if (c!=null) {
			res = mapper.modelMapper().map(c, ClienteRes.class);
		}
		return res;
	}

	@Override
	public List<ClienteRes> listar() {
		List<ClienteRes> res = new ArrayList<ClienteRes>();
		List<Cliente> c = repositorio.findAll();
		if (c!=null) {
			for (Cliente cliente : c) {
				ClienteRes r = new ClienteRes();
				r = mapper.modelMapper().map(cliente, ClienteRes.class);
				res.add(r);
			}
		}
		return res;
	}

}
