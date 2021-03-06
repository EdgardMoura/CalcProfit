package com.calc.huntprofit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.calc.huntprofit.model.HuntProfit;

public interface HuntProfitRepository extends JpaRepository<HuntProfit, Long>{
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true, value="delete from public.hunt_profit where id = ?1")
    public void deleteItem(Long Id);
	
	@Query(nativeQuery=true, value="select count(*) from public.hunt_profit where id = ?1")
    public int countItem(Long Id);
	
	@Query(nativeQuery=true, value="select count(*) from hunt_profit where nome_ed like concat('%',:NomeEd,'%')")
    public String countItem(@Param("NomeEd") String NomeEd);
	
	@Query(nativeQuery=true, value="select * from public.hunt_profit where id = ?1")
    public List<HuntProfit> findItem(Long Id);
	
	@Query(nativeQuery=true, value="select * from hunt_profit where nome_ed like concat('%',:NomeEd,'%')")
    public <NomeEd> List<HuntProfit> findItem(@Param("NomeEd") String NomeEd);

}
