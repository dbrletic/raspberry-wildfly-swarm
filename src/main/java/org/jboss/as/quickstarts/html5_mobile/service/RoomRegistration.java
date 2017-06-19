package org.jboss.as.quickstarts.html5_mobile.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.as.quickstarts.html5_mobile.model.Room;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class RoomRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Room> roomEventSrc;

    public void register(Room room) throws Exception {
        log.info("Registering " + room.getId() + ": " + room.getRoomDesc());
        em.persist(room);
        roomEventSrc.fire(room);
    }
}
