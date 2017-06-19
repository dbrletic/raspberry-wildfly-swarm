package org.jboss.as.quickstarts.html5_mobile.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.as.quickstarts.html5_mobile.data.RoomRepository;
import org.jboss.as.quickstarts.html5_mobile.model.Room;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the rooms table.
 */
@Path("/rooms")
@RequestScoped
@Stateful
public class RoomService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private RoomRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> listAllMembers() {
        return repository.findAllRoomByName();
    }
}
