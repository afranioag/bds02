package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exceptions.EntityNotFoundException;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    public EventDTO update(Long id, EventDTO dto){
        Optional<Event> eventOpt = eventRepository.findById(id);

        if(eventOpt.isEmpty()){
            throw new EntityNotFoundException("Event not found");
        }

        Event event = eventOpt.get();
        Optional<City> cityOpt = cityRepository.findById(dto.getCityId());

        if(cityOpt.isEmpty()){
            throw new EntityNotFoundException("City not found");
        }

        event.setDate(dto.getDate());
        event.setName(dto.getName());
        event.setUrl(dto.getUrl());
        event.setCity(cityOpt.get());

        return new EventDTO(event);
    }
}
