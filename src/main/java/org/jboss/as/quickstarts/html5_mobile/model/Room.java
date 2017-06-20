package org.jboss.as.quickstarts.html5_mobile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "Room_html5mobi", uniqueConstraints = @UniqueConstraint(columnNames = "room_id"))
public class Room {

    /** Default value included to remove warning. Remove or modify at will. **/
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25, message = "1-25 letters and spaces")
    @Column(name = "room_id")
    private String roomId;

    @NotNull
    @NotEmpty
    @Column(name = "room_desc")
    private String roomDesc;

    @NotNull
    @Column(name = "room_occupancy")
    private int roomOccupancy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public int getRoomOccupancy() {
        return roomOccupancy;
    }

    public void setRoomOccupancy(int roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
