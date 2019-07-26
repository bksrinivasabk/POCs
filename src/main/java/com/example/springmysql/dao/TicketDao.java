package com.example.springmysql.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springmysql.model.Ticket;

@Repository
public interface TicketDao extends CrudRepository<Ticket,Integer> {
	
	
}
