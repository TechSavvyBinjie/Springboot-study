package quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.dto.BookDTO;
import quickstart.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {
    @Resource
    private BookService bookService;
    @GetMapping("/getbook")
    public List<BookDTO> getbook(){
        return bookService.getAllBookDTO();
    }
}
