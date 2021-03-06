package com.badar.tms.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.badar.tms.utility.BaseEntity;


@Entity
public class Tickets extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private long id;
	
	@Column(name = "time_frame",nullable = false)
	private String timeToSpend;
	
	@Column(name="ticket_name",nullable= false)
	private String title;
	
	@Column(name="ticket_description",nullable= true)
	private String description;
	private String assignee;

	@ManyToOne
	@JoinColumn(name="parent_id",nullable=true)
	private Tickets parent_id;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="child",joinColumns = { @JoinColumn(name = "parent_id") }, inverseJoinColumns = { @JoinColumn(name = "ticket_id") })
	private Set<Tickets> children = new HashSet<Tickets>();

	public Tickets() {
		super();
	}

	public Tickets(String timeToSpend, String title, String description, String assignee,
			 Tickets parent, Set<Tickets> children) {
		super();
		this.timeToSpend = timeToSpend;
		this.title = title;
		this.description = description;
		this.assignee = assignee;
		this.parent_id = parent;
		this.children = children;
	}

	public long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public String getTimeToSpend() {
		return timeToSpend;
	}

	public void setTimeToSpend(String timeToSpend) {
		this.timeToSpend = timeToSpend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Tickets getParent() {
		return parent_id;
	}

	public void setParent(Tickets parent) {
		this.parent_id = parent;
	}

	public Set<Tickets> getChildren() {
		return children;
	}

	public void setChildren(Set<Tickets> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Tickets [getId()=" + getId() + ", getTimeToSpend()=" + getTimeToSpend() + ", getTitle()=" + getTitle()
				+ ", getDescription()=" + getDescription() + ", getAssignee()=" + getAssignee() + ", getParent()="
				+ getParent() + ", getChildren()=" + getChildren() + "]";
	}

	

	
	
}
