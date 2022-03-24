package org.aleks4ay.roomreservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private final RestTemplate restTemplate;

    @Autowired
    public RoomReservationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<RoomReservation> getAllRoomReservations() {
        List<Room> rooms = getAllRooms();
        List<RoomReservation> roomReservations = new ArrayList<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomNumber(String.valueOf(room.getRoomNumber()) + 1000);
            roomReservations.add(roomReservation);
        });
        return roomReservations;
    }

    private List<Room> getAllRooms() {
//        ResponseEntity<List<Room>> roomResponce = restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {});
        ResponseEntity<List<Room>> roomResponce = new RestTemplate().exchange("http://localhost:8089/room-services/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {});
        return roomResponce.getBody();
    }


    public List<Room> getAllRooms_2() {
        ResponseEntity<Room[]> response = new RestTemplate().getForEntity("http://localhost:8089/room-services/rooms", Room[].class);
        Room[] rooms = response.getBody();
        return rooms == null ? new ArrayList<>() : Arrays.asList(rooms);
    }
}
