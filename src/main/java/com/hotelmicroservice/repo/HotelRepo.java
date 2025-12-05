package com.hotelmicroservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmicroservice.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {

	Optional<Hotel> findByUuid(String hotelUuid);

}
