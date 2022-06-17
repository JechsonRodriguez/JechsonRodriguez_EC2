package com.idat.ec2JechsonRodriguez.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.ec2JechsonRodriguez.modelo.Usuario;
import com.idat.ec2JechsonRodriguez.repositorio.UsuarioRepositorio;


@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByUsuario(username);
		if (usuario!=null) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			GrantedAuthority auth = new SimpleGrantedAuthority(usuario.getRol());
			roles.add(auth);
			return new User(usuario.getUsuario(), usuario.getPassword(),roles);
		}else {
			throw new UsernameNotFoundException("El usuario no existe");
		}
	}

}
