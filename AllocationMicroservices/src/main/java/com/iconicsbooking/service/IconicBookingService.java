package com.iconicsbooking.service;

import java.util.List;
import com.iconicsbooking.model.IconicBooking;

public interface IconicBookingService {
	IconicBooking addComapny(IconicBooking company);

	void updateCompany(IconicBooking company);

	void deleteCompany(int companyId);

	List<IconicBooking> getAll();

	IconicBooking getById(int companyId);
	
	List<IconicBooking> getByCompanyName(String companyName);
	List<IconicBooking> getByOwnerName(String ownerName);
	List<IconicBooking> getByRating(String rating);
}
