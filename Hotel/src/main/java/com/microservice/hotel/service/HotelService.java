package com.microservice.hotel.service;

import com.microservice.hotel.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);

    Hotel getHotelById(String hotelId);

    List<Hotel> getAllHotel();
}
