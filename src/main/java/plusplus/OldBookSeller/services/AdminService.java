package plusplus.OldBookSeller.services;

import org.springframework.stereotype.Service;
import plusplus.OldBookSeller.reponsitory.BookReponsitory;
import plusplus.OldBookSeller.reponsitory.UserRepository;
import plusplus.OldBookSeller.reponsitory.entity.Book;

@Service
public class AdminService {
    BookReponsitory bookReponsitory;
    UserRepository userRepository;
    public String addBook(Book book){
        try {
            bookReponsitory.save(book);
            return "Add book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Add book failed";
        }
    }
    public String updateBook(Book book)
    {
        try {
            bookReponsitory.save(book);
            return "Update book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update book failed";
        }
    }
    public String deleteBook(int bookID)
    {
        try {
            bookReponsitory.deleteById(bookID);
            return "Delete book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete book failed";
        }
    }
    public String deleteUser(int id)
    {
        try {
            bookReponsitory.deleteById(id);
            return "Delete book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete book failed";
        }
    }
}
