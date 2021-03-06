package com.badar.tms.controllers.api.v1;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badar.tms.models.Tickets;
import com.badar.tms.services.TicketService;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
	
	@Autowired(required=true)
	TicketService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tickets>> index() {
		try {

			return new ResponseEntity<>(service.getAllTickets(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/show/{id}")  
	private ResponseEntity<Tickets> show(@PathVariable("id") long id)   
	{  
		try {

			return new ResponseEntity<>(service.getTicketById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showAll/{id}")  
	private ResponseEntity<Set<Tickets>> showChild(@PathVariable("id") long id)   
	{  
		try {

			return new ResponseEntity<>(service.getChildByParentId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<Tickets> save(@RequestBody Tickets data) {
		try {
			service.saveOrUpdate(data);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tickets> update(@PathVariable("id") long id, @RequestBody Tickets data) {

		try{
			service.saveOrUpdate(data);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")  
	private ResponseEntity<HttpStatus> delete(@PathVariable("id") long id)   
	{  
		
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}  
}
