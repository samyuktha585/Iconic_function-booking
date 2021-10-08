package com.iconicsbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.iconicsbooking.model.IconicBooking;
@RestController
public interface IconicBookingRepository extends JpaRepository<IconicBooking, Integer>{
	List<IconicBooking> findByCompanyName(String companyName);
	List<IconicBooking> findByOwnerName(String ownerName);
	List<IconicBooking> findByRating(String rating);
}
