package com.calc.huntprofit.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/cadastro/{email}/{password}")//caminho e o tipo da request, padronizaçao da requisiçao
	public @ResponseBody String cadastro(@PathVariable String email, @PathVariable String password) {//tratamento do corpo da resposta
		DataUser user = new DataUser(email, password);
		userRepository.save(user);
		//.save já é nativo

		return "Success!";

	}
}
