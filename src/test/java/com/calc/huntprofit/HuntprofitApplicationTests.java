package com.calc.huntprofit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.calc.huntprofit.controller.HuntProfitController;
import com.calc.huntprofit.repository.HuntProfitRepository;

@SpringBootTest
class HuntprofitApplicationTests {
	@Autowired
	private HuntProfitController controller;

	@Test
	void contextLoads() {
	}

	@Test
	void test01() {
		System.out.println("Staring teste01");
		assertThat(controller).isNotNull();
		System.out.println("Finished teste01");
	}
	
	@Test
	void test02() {
		System.out.println("Staring teste02");
		assertTrue (controller.countIten(1) == 0);
		System.out.println("Finished teste02");
	}
	
	@Test
	void test03()
	{
		System.out.println("Staring test03");
		assertEquals(controller.Informacao(), "<b>Enter the corresponding values! For Example: <br> "
				+ "/imprimi/Elder Druid name/Ed spending/Party profit </b>");
		System.out.println("Finished test03");
	}

	@Test
	void test04()
	{
		System.out.println("Staring test04");
		assertEquals(controller.Informacao1(), "<b>Non-existent id!! <br> ");
		System.out.println("Finished test04");
	}
	
	@Test
	void test05()
	{
		System.out.println("Staring test05");
		assertEquals(controller.imprimi("Rosane", 322000.0 , 1500000.0), 
				"O gasto do ED Rosane foi de : 322000,00<br>O PROFIT da party foi de : 1500000,00<br>O valor a ser transferido para o Rosane é de : 1072000,00<br>O profit REAL do EK foi de: 750000,00");
		System.out.println("Finished test05");
	}
}
