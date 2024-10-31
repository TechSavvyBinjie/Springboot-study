package quickstart.dto;

import java.util.Date;

public record BookDTO(Long id, String title, String author, Double price) {
    public BookDTO{
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

}
