package plusplus.OldBookSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.Type;
import plusplus.OldBookSeller.services.AdminService;
import plusplus.OldBookSeller.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @GetMapping(value = "/{typeId}")
    public List<Book> getBookInType(@PathVariable int typeId){
        return userService.booksInType(typeId);
    }
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
    public String deleteBookByAdmin(@RequestParam int id)
    {
        return adminService.deleteBook(id);
    }
    @PostMapping(value = "/user/{userId}")
    public String addBookByUser(@RequestBody Book book,@PathVariable int userId)
    {
        return userService.addBook(book,userId);
    }
    @PutMapping(value = "/user/{userId}")
    public String updateBookByUser(@RequestBody Book book,@PathVariable int userId)
    {
        return userService.updateBook(book,userId);
    }
    @DeleteMapping(value = "/user/{userId}")
    public String deleteBookByUser(@RequestParam int bookId,@PathVariable int userId)
    {
        return userService.deleteBook(bookId,userId);
    }
    @PostMapping(value = "/type")
    public String addType(@RequestBody Type type)
    {
        return adminService.addType(type);
    }
    @PutMapping(value = "/type")
    public String updateType(@RequestBody Type type)
    {
        return adminService.updateType(type);
    }
    @DeleteMapping(value = "/type")
    public String deleteType(@RequestParam int id)
    {
        return adminService.deleteType(id);
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
