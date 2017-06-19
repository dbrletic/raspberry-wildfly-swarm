package org.jboss.as.quickstarts.html5_mobile.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.as.quickstarts.html5_mobile.model.Room;

@ApplicationScoped
public class RoomRepository {

    @Inject
    private EntityManager em;

    public Room findById(Long id) {
        return em.find(Room.class, id);
    }

    public Room findbyRoom(String roomId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Room> criteria = cb.createQuery(Room.class);
        Root<Room> rooms = criteria.from(Room.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(rooms).where(cb.equal(rooms.get("roomId"), roomId));

        return em.createQuery(criteria).getSingleResult();
    }

    public List<Room> findAllRoomByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Room> criteria = cb.createQuery(Room.class);
        Root<Room> rooms = criteria.from(Room.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(rooms).orderBy(cb.asc(rooms.get("roomId")));
        return em.createQuery(criteria).getResultList();
    }
}
