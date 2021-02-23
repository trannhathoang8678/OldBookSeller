package plusplus.OldBookSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.User;
import plusplus.OldBookSeller.services.AdminService;
import plusplus.OldBookSeller.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @GetMapping(value = "/sell/{id}")
    public List<Book> getSellingBook(@PathVariable int id) {
        return userService.getBooksUserSell(id, null);
    }

    @GetMapping(value = "/like/{id}")
    public List<Book> getFavoriteBook(@PathVariable int id) {
        return userService.getBooksUserLike(id, null);
    }

    @GetMapping(value = "/{id}")
    public User getUserInfo(@PathVariable int id) {
        return userService.getUserInfo(id);
    }
    @PutMapping(value = "/update/{id}")
    public String updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return adminService.deleteUser(id);
    }
}
