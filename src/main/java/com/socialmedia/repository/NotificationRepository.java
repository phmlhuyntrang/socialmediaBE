package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.Notifications;
import com.socialmedia.model.Users;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

    List<Notifications> findByUser(Users user);
}
