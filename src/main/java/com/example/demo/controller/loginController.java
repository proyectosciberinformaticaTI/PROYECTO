package com.example.demo.controller;

import java.util.Date;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.security.AuthRequest;
//import com.example.demo.security.AuthResponse;
//import com.example.demo.security.JWTUtil;
//import com.example.demo.services.IUsuarioService;

//import com.example.demo.security.AuthRequest;
//import com.example.demo.security.AuthResponse;
//import com.example.demo.security.ErrorLogin;
//import com.example.demo.security.JWTUtil;
//import com.example.demo.services.IUsuarioService;

import reactor.core.publisher.Mono;

@RestController
public class loginController {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/login")
	public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest ar) {
		return service.buscarPorUsuario(ar.getUsername()).map((userDetails) -> {
			String token = jwtUtil.generateToken(userDetails);
			Date expiracion = jwtUtil.getExpirationDateFromToken(token);
			
		//	if (BCrypt.checkpw(ar.getPassword(), userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(token, expiracion));
		//	} else {
			//	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorLogin("credenciales incorrectas", new Date()));
			//}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	

	
	/*
	
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PBKDF2Encoder passwordEncoder;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userService.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	*/
	

}
