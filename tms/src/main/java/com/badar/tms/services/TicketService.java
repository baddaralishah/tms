package com.badar.tms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badar.tms.models.Tickets;
import com.badar.tms.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired(required=true)
	TicketRepository repository;
	
	public List<Tickets> getAllTickets(){
		List<Tickets> data = new ArrayList<Tickets>();  
		repository.findAll().forEach(dum -> data.add(dum));  
		return data;  
	}
	
	public Tickets getTicketById(long id){  
		return repository.findById(id).get();  
	}
	
	public Set<Tickets> getChildByParentId(long id){
		return repository.getChildByParentId(id);  
	}
	
	public void saveOrUpdate(Tickets data){  
	repository.save(data);  
	}
	
	public void delete(long id){  
	repository.deleteById(id);  
	} 
	
	public void update(Tickets data, long id)   
	{  
	repository.save(data);  
	}  
	
}
