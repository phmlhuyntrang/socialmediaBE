package com.socialmedia.model;

import jakarta.persistence.Column;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Friendships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId1")
    private Users user1;

    @ManyToOne
    @JoinColumn(name = "userId2")
    private Users user2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FriendshipStatus status;
    private Date created_at;

    public enum FriendshipStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users user1) {
        this.user1 = user1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
    }

    public FriendshipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendshipStatus status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    

}
