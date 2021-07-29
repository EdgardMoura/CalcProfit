package com.calc.huntprofit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.huntprofit.model.DataUser;
import com.calc.huntprofit.repository.UserRepository;

@RestController//aviso que esta classe sera de controler

public class UserController {
	
	@Autowired//notaçao para utilizaçao de jpa
	UserRepository userRepository;
	
	@RequestMapping(value = "/cadastro/{email}/{pass}")//caminho e o tipo da request, padronizaçao da requisiçao
	public @ResponseBody String cadastro(@PathVariable String email, @PathVariable String pass) {//tratamento do corpo da resposta
		DataUser user = new DataUser(email, pass);
		if(userRepository.existingUser(email) == 1) {
			return "Existing user!";
		}
		else {
		userRepository.save(user);	//.save já é nativo	
		return "Success!";
		}
	}
	
	@RequestMapping(value = "/login/{email}/{pass}")
	public @ResponseBody String validation(@PathVariable String email, @PathVariable String pass)
	{
		if(userRepository.validation(email, pass)!= 0)
		{
		return "Logado com sucesso";
		}
		else {
			return "Incorrect username or password!";
		}
	}
	
	@Transactional
	@Modifying
	@RequestMapping(value = "/trocasenha/{email}/{pass}/{newPass}")
	public @ResponseBody String imprimi(@PathVariable String email, @PathVariable String pass,
			@PathVariable String newPass) {
		DataUser user = new DataUser(email, newPass);
		
		if(userRepository.validation(email, pass) != 1) {
			return "Incorrect username or password!";
		}
		else {			
		userRepository.save(user);

		return "Password changed successfully!";
		}
	}
}
