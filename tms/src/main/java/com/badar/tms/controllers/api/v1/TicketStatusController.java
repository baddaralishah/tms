package com.badar.tms.controllers.api.v1;

import java.util.List;

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

import com.badar.tms.models.TStatuses;
import com.badar.tms.services.StatuService;

@RestController
@RequestMapping("/api/v1/status")
public class TicketStatusController {

	@Autowired(required=true)
	StatuService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<TStatuses>> index() {
		try {

			return new ResponseEntity<>(service.getAllTStatuses(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/show/{id}")  
	private ResponseEntity<TStatuses> show(@PathVariable("id") long id)   
	{  
		try {

			return new ResponseEntity<>(service.getStatusById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/show-by-ticket/{id}")  
	private ResponseEntity<List<TStatuses>> showByTicket(@PathVariable("id") long id)   
	{  
		try {
			
			return new ResponseEntity<>(service.findByTicketId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(service.findByTicketId(id), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<TStatuses> save(@RequestBody TStatuses data) {
		try {
			service.saveOrUpdate(data);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TStatuses> update(@PathVariable("id") long id, @RequestBody TStatuses data) {

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
