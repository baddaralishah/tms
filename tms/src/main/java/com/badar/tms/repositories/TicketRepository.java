package com.badar.tms.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.badar.tms.models.Tickets;

@Repository
public interface TicketRepository  extends JpaRepository<Tickets, Long>{

	@Query(value="SELECT * from Tickets where parent_id =:id", nativeQuery = true)
	public Set<Tickets> getChildByParentId(long id);
}



