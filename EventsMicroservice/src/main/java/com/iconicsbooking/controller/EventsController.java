package com.iconicsbooking.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iconicsbooking.model.Events;
import com.iconicsbooking.model.Status;
import com.iconicsbooking.model.Task;
import com.iconicsbooking.service.IEventService;

@RestController
@RequestMapping("events_api")
public class EventsController {
	@Autowired
	IEventService eventService;
	
	@PostMapping("/events")
	Events addEvent(@RequestBody Events event)
	{
	return eventService.addEvent(event);
	}
	@DeleteMapping("/events")
	void deleteEvent(int eventId)
	{
		eventService.deleteEvent(eventId);
	}
	@GetMapping("/events")
	List<Events> getAll()
	{
		return eventService.getAll();
	}
	@GetMapping("/events/eventId/{eventId}")
	ResponseEntity<Events> getById(@PathVariable("eventId") int eventId)
	{
		Events event = eventService.getById(eventId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get one event by Id");
		headers.add("info","Returning one event");
		ResponseEntity<Events> responseEvent = new ResponseEntity<Events>(event,headers,HttpStatus.OK);
		return responseEvent;
	}
	@GetMapping("/events/eventName/{eventName}")
	ResponseEntity<List<Events>> getByEventName(@PathVariable("eventName") String eventName)
	{
		List<Events> eventsByname = eventService.getByEventName(eventName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By event name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(eventsByname);
	}
	@GetMapping("/events/eventProvider/{eventProvider}")
	ResponseEntity<List<Events>> getByEventProvider(@PathVariable("eventProvider") String eventProvider)
	{
		List<Events> eventsByProvider = eventService.getByEventProvider(eventProvider);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By event provider");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(eventsByProvider);
	}
	@GetMapping("/events/priority/{priority}")
	ResponseEntity<List<Events>> getByEventPriority(@PathVariable("priority") String priority)
	{
		List<Events> eventsByPriority = eventService.getByPriority(priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By event priority");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(eventsByPriority);
	}
	@GetMapping("/events/status/{status}")
	ResponseEntity<List<Events>> getByEventStatus(@PathVariable("status") String status)
	{
		List<Events> eventsByStatus = eventService.getByPriority(status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By event status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(eventsByStatus);
	}
	@GetMapping("/events/price/{price}")
	ResponseEntity<List<Events>> getByEventPrice(@PathVariable("price") int price)
	{
		List<Events> eventsByPrice = eventService.getByPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By event Price");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(eventsByPrice);
	
	}
	@GetMapping("/task/taskId/{taskId}")
	ResponseEntity<Task> getBytaskId(@PathVariable("taskId") int taskId)
	{
		Task task = eventService.getBytaskId(taskId);
	HttpHeaders headers = new HttpHeaders();
	ResponseEntity<Task> response = new ResponseEntity<Task>(task,headers,HttpStatus.OK);
	return response;
		
	}
	@GetMapping("/task")
	List<Task>getAllTasks()
	{
		return eventService.getAllTasks();
	}
	@GetMapping("/task/organiserName/{organiserName}")
	ResponseEntity<List<Task>>  getByOrganiser(@PathVariable("organiserName") String organiserName)
	{
		List<Task> task = eventService.getByOrganiser(organiserName);
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(task);
		
	}
	@GetMapping("/task/taskName/{taskName}")
	ResponseEntity<List<Task>>  getByTaskName(@PathVariable("taskName")  String taskName)
	{
		List<Task> task = eventService.getByOrganiser(taskName);
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(task);
	}
	@GetMapping("/task/startDate/{startDate}")
	ResponseEntity<List<Task>> getByTaskStartDate(@PathVariable("startDate")  LocalDate startDate)
	{
		List<Task> task = eventService.getByStartDate(startDate);
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(task);
	}
//	List<Task>getByTaskEndDate(LocalDate endDate);
//	List<Task>getByRating(double rating);
//	List<Task>getByStatus(Status status);
	

}