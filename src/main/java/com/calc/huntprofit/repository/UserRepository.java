package com.calc.huntprofit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.calc.huntprofit.model.DataUser;

	public interface UserRepository extends JpaRepository<DataUser, Long>{
		//esta interface eh necessaria para execuçao automatica das query, as personalizaçoes de query serao feitas aqui
		@Query(nativeQuery=true, value="select count(*) from data_user where (email = ?1 and pass= ?2)")
	    public int validation(String email, String pass);
		
		
		@Query(nativeQuery=true, value="select count(*) from data_user where (email = ?1)")
	    public int existingUser(String email);
		
}
