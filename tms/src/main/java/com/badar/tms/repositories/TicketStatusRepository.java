package com.badar.tms.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.badar.tms.models.TStatuses;

@Repository
@Transactional
public interface TicketStatusRepository  extends JpaRepository<TStatuses, Long>{

	@Query("SELECT a from TStatuses a where a.ticket_id =:id")
	List<TStatuses> findByTicketId(long id);
}
