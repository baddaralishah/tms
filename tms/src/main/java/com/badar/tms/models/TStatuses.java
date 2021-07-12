package com.badar.tms.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.badar.tms.enumrations.TicketStatuses;
import com.badar.tms.utility.BaseEntity;

@Entity
public class TStatuses extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private TicketStatuses status;

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Tickets ticket_id;

	public TStatuses() {
		super();
	}

	public TStatuses(TicketStatuses status, Tickets ticket) {
		super();
		this.status = status;
		this.ticket_id = ticket;
	}

	public long getId() {
		return id;
	}

	public TicketStatuses getStatus() {
		return status;
	}

	public void setStatus(TicketStatuses status) {
		this.status = status;
	}


	public Tickets getTicket() {
		return ticket_id;
	}

	public void setTicket(Tickets ticket) {
		this.ticket_id = ticket;
	}

	@Override
	public String toString() {
		return "TStatuses [getId()=" + getId() + ", getStatus()=" + getStatus() + ", getTicket()=" + getTicket() + "]";
	}

	
    
    
}
