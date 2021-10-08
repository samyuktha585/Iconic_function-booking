package com.iconicsbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iconicsbooking.model.IconicBooking;
import com.iconicsbooking.repository.IconicBookingRepository;
@Service
public class IconicBookingServiceImpl implements IconicBookingService {
@Autowired
IconicBookingRepository iconicBookingRepository;
	@Override
	public IconicBooking addComapny(IconicBooking company) {
		return iconicBookingRepository.save(company);
	}

	@Override
	public void updateCompany(IconicBooking company) {
		iconicBookingRepository.save(company);		
	}

	@Override
	public void deleteCompany(int companyId) {
		iconicBookingRepository.deleteById(companyId);
	}

	@Override
	public List<IconicBooking> getAll() {
		return iconicBookingRepository.findAll();
	}

	@Override
	public IconicBooking getById(int companyId) {
		return iconicBookingRepository.findById(companyId).get();
	}

	@Override
	public List<IconicBooking> getByCompanyName(String companyName) {
		return iconicBookingRepository.findByCompanyName(companyName);
	}

	@Override
	public List<IconicBooking> getByOwnerName(String ownerName) {
		return iconicBookingRepository.findByOwnerName(ownerName);
	}

	@Override
	public List<IconicBooking> getByRating(String rating) {
		return iconicBookingRepository.findByRating(rating);
	}

}
