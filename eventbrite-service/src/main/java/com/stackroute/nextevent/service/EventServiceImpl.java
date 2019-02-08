package com.stackroute.nextevent.service;

import com.stackroute.nextevent.exception.EventAlreadyExist;
import com.stackroute.nextevent.exception.EventNotFound;
import com.stackroute.nextevent.model.Event;
import com.stackroute.nextevent.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private static Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private EventRepository eventRepository;

    @Autowired
    EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event saveEvent(Event event) throws EventAlreadyExist {
        Optional optional = eventRepository.findById(event.getId());
        if (optional.isPresent())
            throw new EventAlreadyExist("Event already exists");
        else
            return eventRepository.save(event);
    }

    @Override
    public boolean deleteEvent(String id) throws EventNotFound {
        Optional optional = eventRepository.findById(id);
        log.info("check event+++++++" + optional);
        if (optional.isPresent()) {
            eventRepository.deleteById(id);
            System.out.println("Id is" + id);
            return true;
        } else {
            throw new EventNotFound("Event not Found");
        }
    }

    @Override
    public Event updateEvent(Event event, String id) throws EventNotFound {

        Optional optional = eventRepository.findById(id);
        if (optional.isPresent()) {
            event = eventRepository.findById(id).get();
            event.setCreated(event.getCreated());
            event.setDescription(event.getDescription());
            event.setEnd(event.getEnd());
            event.setStart(event.getStart());
            event.setImageUrl(event.getImageUrl());
            event.setName(event.getName());
            event.setCategory(event.getCategory());
            log.info("event is======" + event);
            log.info("updated event Saved");
            eventRepository.save(event);

        } else {
            throw new EventNotFound("Event not found");
        }
        return event;

    }

    @Override
    public Event getEventById(String id) throws EventNotFound {
        Optional optional = eventRepository.findById(id);
        if (optional.isPresent()) {
            log.info("inside if evntId found");
            return eventRepository.findById(id).get();
        } else {
            throw new EventNotFound("Event not Found");
        }

    }

    @Override
    public List<Event> getAllEvent() throws EventNotFound {
        //return null;
        return eventRepository.findAll();

    }
}
