package com.example.springmysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmysql.dao.TicketDao;
import com.example.springmysql.model.Ticket;

@RestController
@RequestMapping("/Ticket")
public class TicketController {

	@Autowired
	private TicketDao dao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		dao.saveAll(tickets);
		return "Tickets booked : " +tickets.size();
		
	}
	
	@GetMapping("/getTickets")
	public List<Ticket> getTickets()
	{
		List<Ticket> tickets;
		tickets = (List<Ticket>) dao.findAll();
		System.out.println(tickets.toString());
		
		return tickets;
				//(List<Ticket>) dao.findAll();
		
		
	}
	
	@GetMapping("/getTicketById/{id}")
	public Optional<Ticket> getTicketById(@PathVariable int id)
	{
		return dao.findById(id);
		
	}
	
	
	
}
