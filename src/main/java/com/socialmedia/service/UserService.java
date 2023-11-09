package com.socialmedia.service;

import java.util.List;
import com.socialmedia.model.Users;
import java.io.FileNotFoundException;
import java.sql.Date;
//import java.util.Date;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public Users saveUser(Users user);
    public List<Users> getAllUsers();
    public Users getUserByUsername(String username);
    public Optional<Users> getUserById(int id);
    public void changeUserPassword(int id, String currentPassword ,String newPassword);
    public void loadData(String filPath) throws FileNotFoundException;
    public void updateAvatar(Integer id, MultipartFile avatarfile);
    public void changeUserPrivateState(int id, boolean currentState);
    public void changeUserbirthday(int id, Date birthday);
    
}
