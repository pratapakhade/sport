package com.sport.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sport.entity.CardEntity;

	@Repository
	public interface ICardRepository extends JpaRepository<CardEntity,Long>{

	}



