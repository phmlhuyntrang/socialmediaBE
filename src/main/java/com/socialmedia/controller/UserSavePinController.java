package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.model.Users;
import com.socialmedia.service.BoardService;
import com.socialmedia.service.PinService;
import com.socialmedia.service.UserSavePinService;
import com.socialmedia.service.UserService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/userSavePin")
@CrossOrigin
public class UserSavePinController {

    @Autowired
    private UserSavePinService userSavePinservice;
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private PinService pinService;


    @GetMapping(value = "/getAll")
    public List<UserSavePin> getAllUserSavePin() {
        return userSavePinservice.getAllUserSavePin();
    }

    @GetMapping("getPinByUser/{userId}")
    public List<UserSavePin> getPinByUserId(@PathVariable("id") int id) {
        Optional<Users> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            List<UserSavePin> list = userSavePinservice.findAllByUSer(user);
            return list;
        } else {
            return null;
        }
    }
    
    @GetMapping("getPin/{username}/{boardId}")
    public List<Pins> getPinByUserIdAndBoardId(@PathVariable("username") String username, @PathVariable("boardId") int boardId) {
        Optional<Boards> optionalBoard = boardService.findById(boardId);
        Boards board = new Boards();
        if (optionalBoard.isPresent()) {
            board = optionalBoard.get();
        }

        Users user = userService.getUserByUsername(username);

        List<UserSavePin> listUserSavePin = new ArrayList<UserSavePin>();
        List<Pins> listPin = new ArrayList<Pins>();

        if (optionalBoard.isPresent() && user != null) {
            listUserSavePin = userSavePinservice.findAllByUserAndBoard(user, board);

            for (UserSavePin item : listUserSavePin) {
                listPin.add(item.getPin());
            }

        }
        return listPin;
    }

    @PostMapping("/add")
    public boolean savePin(@RequestBody UserSavePin userSavePin) {
        userSavePinservice.saveUserSavePin(userSavePin);
        return true;
    }

    @GetMapping("/boardId/{id}")
    public List<UserSavePin> getPinByBoardId(@PathVariable("id") int id) {
        Optional<Boards> optionalBoard = boardService.findById(id);
        if (optionalBoard.isPresent()) {
            Boards board = optionalBoard.get();
            List<UserSavePin> list = userSavePinservice.findAllByBoard(board);
            return list;
        } else {
            return null;
        }

    }


    @PostMapping("/delete")
    public boolean delete(@RequestBody UserSavePin userSavePin) {
        userSavePinservice.delete(userSavePin);
        return true;
    }

}
