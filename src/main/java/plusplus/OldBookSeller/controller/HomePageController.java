package plusplus.OldBookSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.Type;
import plusplus.OldBookSeller.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class HomePageController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/type")
    public List<Book> booksOfType(@RequestParam int typeID)
    {
        return userService.booksInType(typeID);
    }
    @GetMapping
    public List<Type> bookTypes()
    {
        return userService.getBooksTypes();
    }
    @GetMapping(value="/{id}")
    public Book bookInDetail(@PathVariable int id)
    {
        return userService.bookInDetail(id);
    }
}
