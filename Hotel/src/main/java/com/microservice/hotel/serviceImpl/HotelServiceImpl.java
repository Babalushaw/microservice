package com.microservice.hotel.serviceImpl;

import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.model.Hotel;
import com.microservice.hotel.repository.HotelRepository;
import com.microservice.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("Hotel is not present with given id")
        );
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
