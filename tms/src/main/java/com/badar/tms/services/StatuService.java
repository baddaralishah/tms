package com.badar.tms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.badar.tms.models.TStatuses;
import com.badar.tms.repositories.TicketStatusRepository;

@Service
public class StatuService {

	@Autowired(required=true)
	TicketStatusRepository repository;
	
	public List<TStatuses> getAllTStatuses(){
		List<TStatuses> data = new ArrayList<TStatuses>();  
		repository.findAll().forEach(dum -> data.add(dum));  
		return data;  
	}
	
	public TStatuses getStatusById(long id){  
		return repository.findById(id).get();  
	}
	
	public List<TStatuses> findByTicketId(long id){
		return repository.findByTicketId(id);
	}
	
	public void saveOrUpdate(TStatuses data){  
	repository.save(data);  
	}
	
	public void delete(long id){  
	repository.deleteById(id);  
	} 
	
	public void update(TStatuses data, long id)   
	{  
	repository.save(data);  
	}
}
