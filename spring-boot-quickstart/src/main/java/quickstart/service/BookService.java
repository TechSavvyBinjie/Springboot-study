package quickstart.service;

import org.springframework.stereotype.Service;
import quickstart.dto.BookDTO;

import java.util.List;
@Service
public class BookService {
    public List<BookDTO> getAllBookDTO(){
        return List.of(new BookDTO(1l,"12","1",1.0),
                new BookDTO(2l,"Spring BBoot in Action","Bob",34.99));
    }
}
