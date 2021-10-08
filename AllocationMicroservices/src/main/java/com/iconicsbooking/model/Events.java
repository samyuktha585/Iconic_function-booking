package com.iconicsbooking.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Events {	

	@Id
	@GeneratedValue(generator = "event_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "event_gen", sequenceName = "event_seq", initialValue = 100, allocationSize = 1)
	private Integer eventId;
	private String eventName;
	private String eventProvider;
	private LocalDate startDate;
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
    private Status status;
	private double price;
    @ManyToOne
    @JoinColumn(name = "company_id")
    IconicBooking iconicBooking;
    
	@OneToMany
	@JoinColumn(name = "event_id")
	 Set<TaskService> taskServiceList;

	public Events(String eventName, String eventProvider, LocalDate startDate, LocalDate endDate, Priority priority,
			Status status, double price) {
		super();
		this.eventName = eventName;
		this.eventProvider = eventProvider;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.price = price;
		//this.iconicBooking = iconicBooking;
	}

	@Override
	public String toString() {
		return "Events [eventName=" + eventName + ", eventProvider=" + eventProvider + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", status=" + status + ", price=" + price
				+ ", iconicBooking=" + iconicBooking + "]";
	}

	


}