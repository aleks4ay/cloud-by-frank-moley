package org.aleks4ay.guestservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository repository;

    @Autowired
    public GuestController(GuestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Guest getGuest(@PathVariable("id") long id) {
        return repository.findById(id).get();
    }
}
