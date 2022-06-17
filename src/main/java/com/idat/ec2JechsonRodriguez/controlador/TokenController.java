package com.idat.ec2JechsonRodriguez.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec2JechsonRodriguez.dto.TokenRes;
import com.idat.ec2JechsonRodriguez.dto.UsuarioReq;
import com.idat.ec2JechsonRodriguez.seguridad.UserDetailService;
import com.idat.ec2JechsonRodriguez.utilitarios.JwtUtil;

@RestController
public class TokenController {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailService service;
	
	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioReq dto){
		UserDetails detail = service.loadUserByUsername(dto.getUsuario());
		return ResponseEntity.ok(new TokenRes(util.generateToken(detail.getUsername())));
	}
}
