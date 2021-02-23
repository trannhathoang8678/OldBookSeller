package plusplus.OldBookSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.services.AdminService;
import plusplus.OldBookSeller.services.UserService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @PostMapping(value = "/admin")
    public String addBookByAdmin(@RequestBody Book book)
    {
        return adminService.addBook(book);
    }
    @PutMapping(value = "/admin")
    public String updateBookByAdmin(@RequestBody Book book)
    {
        return adminService.updateBook(book);
    }
    @DeleteMapping(value = "/admin")
    public String addBookByAdmin(@RequestParam int id)
    {
        return adminService.deleteBook(id);
    }
    @PostMapping(value = "/user/{id}")
    public String addBookByUser(@RequestBody Book book,@PathVariable int userId)
    {
        return userService.addBook(book,userId);
    }
    @PutMapping(value = "/user/{id}")
    public String updateBookByUser(@RequestBody Book book,@PathVariable int userId)
    {
        return userService.updateBook(book,userId);
    }
    @DeleteMapping(value = "/user/{id}")
    public String addBookByUser(@RequestParam int bookId,@PathVariable int userId)
    {
        return userService.deleteBook(bookId,userId);
    }
    @PostMapping(value = "/like/user/{userId}")
    public String addFavoriteBook(@PathVariable int userId,@RequestParam int bookId )
    {
        return userService.markFavoriteBook(bookId,userId);
    }
    @PostMapping(value = "/unlike/user/{userId}")
    public String deleteFavoriteBook(@PathVariable int userId,@RequestParam int bookId )
    {
        return userService.unmarkFavoriteBook(bookId,userId);
    }
}
