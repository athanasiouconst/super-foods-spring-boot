package com.superfoods.superfoods.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperFoodJpaRepository extends JpaRepository<SuperFood, Long>{
	List<SuperFood> findByUsername(String username);
}
