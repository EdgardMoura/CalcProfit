package com.calc.huntprofit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.calc.huntprofit.model.DataUser;

	public interface UserRepository extends JpaRepository<DataUser, Long>{
		//esta interface eh necessaria para execuçao automatica das query, as personalizaçoes de query serao feitas aqui
		@Query(nativeQuery=true, value="select count(*) from data_user where (email = ?1 and password= ?2)")
	    public int countItem(String email, String password);
		
		
}
