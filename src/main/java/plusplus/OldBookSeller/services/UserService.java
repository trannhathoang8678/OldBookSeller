package plusplus.OldBookSeller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import plusplus.OldBookSeller.reponsitory.BookReponsitory;
import plusplus.OldBookSeller.reponsitory.TypeRepository;
import plusplus.OldBookSeller.reponsitory.UserBookRelationshipRepository;
import plusplus.OldBookSeller.reponsitory.UserRepository;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.Type;
import plusplus.OldBookSeller.reponsitory.entity.User;
import plusplus.OldBookSeller.reponsitory.entity.UserBookRelationship;


import java.security.SecureRandom;
import java.util.List;

@Service
public class UserService {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DATA_FOR_RANDOM_STRING = CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();
    @Autowired
    SendEmailService sendEmailService;
    UserRepository userRepository;
    BookReponsitory bookReponsitory;
    TypeRepository typeRepository;
    UserBookRelationshipRepository userBookRelationshipRepository;
    public String login(String email, String password) {
        if (userRepository.existsByEmailAndPassword(email, password))
            return "Login successfull";
        else
            return "Wrong email or password";
    }

    public String register(String email, String password, String phonenumber, String token) {
        User temporaryUser = userRepository.findOneByEmail(email);
        if (temporaryUser == null)
            return "Please click sent token button";
        if (temporaryUser.getPassword() != null)
            return "Email has already regitered";
        String sentToken = temporaryUser.getToken();
        if (!sentToken.equals(token))
            return "Wrong token, please check or send another token ";
        temporaryUser.setPassword(password);
        temporaryUser.setPhonenumber(phonenumber);
        userRepository.save(temporaryUser);
        return "Register success";
    }

    public String sendTokenToEmail(String email) {
        try
        {User temporaryUser = userRepository.findOneByEmail(email);
        String token = generateRandomString(6);
        if (temporaryUser == null) {
            temporaryUser = new User(email, token);
        } else {
            temporaryUser.setToken(token);
        }
        userRepository.save(temporaryUser);
        sendEmailService.sendEmail("Token",email,token);
        return "Sent token to email";}
        catch (Exception e)
        {
            e.printStackTrace();
            return "Send token failed";
        }
    }

    public String retrievePassword(String email,String token) {
        sendTokenToEmail(email);
        User temporaryUser = userRepository.findOneByEmail(email);
        if ( temporaryUser.getPassword() == null)
            return "Email have not been registerd";
        String sentToken = temporaryUser.getToken();
        if (!sentToken.equals(token))
            return "Wrong token, please check or send another token ";
        return "Password: " + temporaryUser.getPassword();
    }
    public List<Type> getBooksTypes()
    {
        return typeRepository.findAll();
    }
    public List<Book> booksInType(int typeID) {
        try {
            return bookReponsitory.findAllByType(typeID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> booksHaveTitle(String title, Pageable pageable) {
        try {
            return bookReponsitory.findByTitle(title, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book bookInDetail(int id) {
        try {
            return bookReponsitory.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Book> getBooksUserSell(int userID,Pageable pageable)
    {
        try {
           return bookReponsitory.findAllByIdIn(userBookRelationshipRepository.findBookIdsWithRelationship(userID,"sell"),pageable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Book> getBooksUserLike(int userID,Pageable pageable)
    {
        try {
            return bookReponsitory.findAllByIdIn(userBookRelationshipRepository.findBookIdsWithRelationship(userID,"like"),pageable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserInfo(int id) {
        try {
            return userRepository.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String updateUserInfo(User user)
    {
        if(!userRepository.existsById(user.getId()))
            return "user is not exist";
        userRepository.save(user);
        return "update successfully";
    }
    public String markFavoriteBook(int bookID,int userID)
    {
        try {

            userBookRelationshipRepository.save(new UserBookRelationship(new Book(bookID),new User(userID),"like"));
            return "Mark book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Mark book failed";
        }
    }
    public String unmarkFavoriteBook(int bookID,int userID)
    {
        try {

            userBookRelationshipRepository.delete(userBookRelationshipRepository.findOneByBookAndUserAndRelationship(bookID,userID,"like"));
            return "Unmark book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Unmark book failed";
        }
    }
    public String addBook(Book book,int userID){
        try {
            bookReponsitory.save(book);
            userBookRelationshipRepository.save(new UserBookRelationship(book,new User(userID),"sell"));
            return "Add book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Add book failed";
        }
    }
    public String updateBook(Book book,int userID)
    {
        try {
            if(verifyUserBook(book.getId(),userID))
                return "This is not your book";
            bookReponsitory.save(book);
            return "Update book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update book failed";
        }
    }
    public String deleteBook(int bookID,int userID)
    {
        try {
            if(verifyUserBook(bookID,userID))
                return "This is not your book";
            bookReponsitory.deleteById(bookID);
            userBookRelationshipRepository.delete(userBookRelationshipRepository.findOneByBookAndUserAndRelationship(bookID,userID,"sell"));
            return "Delete book successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Delete book failed";
        }
    }
    public boolean verifyUserBook(int bookID,int userID)
    {
        try {
            return userBookRelationshipRepository.existsByBookAndUserAndRelationship(bookID,userID,"sell");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
