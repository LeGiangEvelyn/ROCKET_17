//package com.vti.controller;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vti.dto.UserDto;
//import com.vti.entity.User;
//import com.vti.service.IUserService;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping(value = "/api/v1/login")
//public class AuthController {
//
//	@Autowired
//	private IUserService service;
//
//	@GetMapping()
//	public ResponseEntity<?> login(Principal pricipal) {
//		String userName = pricipal.getName();
//		User entity = service.findByUserName(userName);
//		UserDto dtoUser = new UserDto(entity.getId(), entity.getEmail(), entity.getFirstName(), entity.getLastName(), entity.getFullName());
//		
//		return new ResponseEntity<>(dtoUser, HttpStatus.OK);
//	}
//}
