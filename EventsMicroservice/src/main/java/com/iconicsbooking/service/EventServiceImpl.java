package com.iconicsbooking.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iconicsbooking.model.Events;
import com.iconicsbooking.model.Priority;
import com.iconicsbooking.model.Status;
import com.iconicsbooking.model.Task;
import com.iconicsbooking.repository.IEventRepository;

@Service
@Transactional
public class EventServiceImpl implements IEventService{
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	IEventRepository eventRepository;
	public static final String BASEURL = "http://localhost:8080/task-api";
	public void setEventRepository(IEventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public Events addEvent(Events events) {
		return eventRepository.save(events);
	}

	@Override
	public void updateEvent(Events events) {
		eventRepository.save(events);		
	}

	@Override
	public void deleteEvent(int eventId) {
		eventRepository.deleteById(eventId);		
	}

	@Override
	public List<Events> getAll() {
		return eventRepository.findAll();
	}

	@Override
	public Events getById(int serviceId) {
		return eventRepository.getById(serviceId);
	}


	@Override
	public List<Events> getByEventName(String eventName) {
		return eventRepository.findByEventName(eventName);
	}

	@Override
	public List<Events> getByStartDate(LocalDate startDate) {
		return eventRepository.findByStartDate(startDate);
	}

	@Override
	public List<Events> getByEndDate(LocalDate endDate) {
		return eventRepository.findByEndDate(endDate);
	}

	@Override
	public List<Events> getByStatus(String status) {
		Status statusValue= Status.valueOf(status);
		List<Events> status1 = eventRepository.findByStatus(statusValue);
	//	return 
		return status1;
	}

	@Override
	public List<Events> getByPrice(double price) {
		return eventRepository.findByPrice(price);
	}

	@Override
	public List<Events> getByEventProvider(String eventProvider) {
		return eventRepository.findByEventProvider(eventProvider);
	}

	@Override
	public List<Events> getByPriority(String priority) {
		Priority priorityValue = Priority.valueOf(priority);
		List<Events> priority1 = eventRepository.findByPriority(priorityValue);
		return priority1;
	}

//	@Override
//	public List<Events> getByStatus(Availability avail) {
//		Availability availValue = Availability.valueOf(avail);
//		return eventRepository.findByStatus(avail);
//	}

	@Override
	public int assignEvent(int companyId, int eventId) {
		return eventRepository.assignEvent(companyId, eventId);
	}

	@Override
	public int changeStatus(Status status, int eventId) {
		return eventRepository.changeStatus(status, eventId);
	}

	@Override
	public Task getBytaskId(int taskId) {
		String url = BASEURL +"/task/" +taskId;
		ResponseEntity<Task> response = restTemplate.getForEntity(url,Task.class);
		System.out.println(response.getStatusCodeValue()+ " "+response);
		return response.getBody();
		
	}

	@Override
	public List<Task> getAllTasks() {
		String url = BASEURL + "/task";
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		return response.getBody();
	}

	@Override
	public List<Task> getByOrganiser(String organiserName) {
		String url = BASEURL + "/task/organiserName/" + organiserName;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		
		System.out.println(response.getStatusCodeValue() + "....");
		return response.getBody();
	}

	@Override
	public List<Task> getByTaskName(String taskName) {
		String url = BASEURL + "/task/taskName/" + taskName;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		
		System.out.println(response.getStatusCodeValue() + "....");
		return response.getBody();
	}

	@Override
	public List<Task> getByTaskStartDate(LocalDate taskstartDate) {
		String url = BASEURL + "/task/taskstartDate/" + taskstartDate;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		
		System.out.println(response.getStatusCodeValue() + "....");
		return response.getBody();
	}

	@Override
	public List<Task> getByTaskEndDate(LocalDate taskendDate) {
			String url = BASEURL + "/task/taskendDate/" + taskendDate;
			ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
			
			System.out.println(response.getStatusCodeValue() + "....");
			return response.getBody();
	}

	@Override
	public List<Task> getByRating(double rating) {
		String url = BASEURL + "/task/rating/" + rating;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		
		System.out.println(response.getStatusCodeValue() + "....");
		return response.getBody();
	}

	@Override
	public List<Task> getByStatus(Status status) {
		String url = BASEURL + "/task/status/" + status;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		System.out.println(response.getStatusCodeValue() + "....");
		return response.getBody();
	}
	


	
}
