package com.sport.service;


	import java.util.List;

import com.sport.entity.CardEntity;
	

	public interface ICardService {
		
		public CardEntity addCard(CardEntity card);
		public CardEntity removeCard(Long id);
		public CardEntity updateCard(Long id, CardEntity card);
		public CardEntity getCardDetails(Long id);
		public List<CardEntity> getAllCards();

	}



