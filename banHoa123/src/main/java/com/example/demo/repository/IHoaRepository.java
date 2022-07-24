package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ChuDeHoas;
import com.example.demo.entity.Hoa;

public interface IHoaRepository extends JpaRepository<Hoa, Integer> {
	@Query("SELECT DISTINCT p FROM Hoa p JOIN p.chuDeHoa c WHERE c.tenChuDeHoa LIKE %?1% OR p.ten LIKE %?1% ")
	public Page<Hoa> findByChuDeHoaLike1(String tenChuDeHoa, Pageable pageable);
	
	//public List<Hoa> findByTenLike(String ten);
	public Page<Hoa> findByTenLike(String ten, Pageable pageable);
	//	List<Hoa> findByIdLike(Integer id);
//	List<Hoa> findByTenLike(String ten);
	//Page<Hoa> findByType(HoaType type);
//	Page<Hoa> findByTypeLike(HoaType type,  Pageable pageable);
}
