package plusplus.OldBookSeller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plusplus.OldBookSeller.reponsitory.BookRepository;
import plusplus.OldBookSeller.reponsitory.TypeRepository;
import plusplus.OldBookSeller.reponsitory.UserRepository;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.Type;

@Service
public class AdminService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TypeRepository typeRepository;

    public String addBook(Book book) {
        try {
            Type type = typeRepository.findOneByName(book.getType().getName());
            if (type != null)
                book.setTypeId(type.getId());
            bookRepository.save(book);
            return "Add book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Add book failed";
        }
    }

    public String updateBook(Book book) {
        try {
            Type type = typeRepository.findOneByName(book.getType().getName());
            if (type != null)
                book.setTypeId(type.getId());
            System.out.println(type.getId());
            bookRepository.save(book);
            return "Update book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update book failed";
        }
    }

    public String deleteBook(int bookID) {
        try {
            bookRepository.deleteById(bookID);
            return "Delete book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete book failed";

        }
    }

    public String addType(Type type) {
        try {

            typeRepository.save(type);
            return "Add type  successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Add type  failed";
        }
    }

    public String updateType(Type type) {
        try {

            typeRepository.save(type);
            return "Update type  successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update type  failed";
        }
    }

    public String deleteType(int typeID) {
        try {
            typeRepository.deleteById(typeID);
            return "Delete type  successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete type  failed";
        }
    }

    public String deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return "Delete user successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete user failed";
        }
    }
}
