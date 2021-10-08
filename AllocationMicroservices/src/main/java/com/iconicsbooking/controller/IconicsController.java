package com.iconicsbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iconicsbooking.model.IconicBooking;
import com.iconicsbooking.service.IconicBookingService;

@RestController
@RequestMapping("company_api")
public class IconicsController {
	@Autowired
	IconicBookingService iBookingService;
	
	@PostMapping("/company")
	IconicBooking addCompany(@RequestBody IconicBooking company)
	{
	return iBookingService.addComapny(null);
	}
	@DeleteMapping("/company")
	void deleteCompany(int companyId)
	{
		iBookingService.deleteCompany(companyId);
	}
	@GetMapping("/company")
	List<IconicBooking> getAll()
	{
		return iBookingService.getAll();
	}
	@GetMapping("/company/companyId/{companyId}")
	ResponseEntity<IconicBooking> getById(@PathVariable("companyId") int companyId)
	{
		IconicBooking comapanyById = iBookingService.getById(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get one event by Id");
		headers.add("info","Returning one event");
		ResponseEntity<IconicBooking> responseCompany = new ResponseEntity<IconicBooking>(comapanyById,headers,HttpStatus.OK);
		return responseCompany;
	}
	@GetMapping("/comapny/companyName/{companyName}")
	ResponseEntity<List<IconicBooking>> getByCompanyName(@PathVariable("companyName") String companyName)
	{
		List<IconicBooking> companyByname = iBookingService.getByCompanyName(companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By company name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyByname);
	}
	@GetMapping("/company/rating/{rating}")
	ResponseEntity<List<IconicBooking>> getByRating(@PathVariable("rating") String rating)
	{
		List<IconicBooking> companyByRating = iBookingService.getByRating(rating);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By company rating");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyByRating);
	}
	@GetMapping("/company/ownerName/{ownerName}")
	ResponseEntity<List<IconicBooking>> getByOwnerName(@PathVariable("ownerName") String ownerName)
	{
		List<IconicBooking> companyByOwnerName = iBookingService.getByOwnerName(ownerName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get eventList By company owner name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyByOwnerName);
	}
}