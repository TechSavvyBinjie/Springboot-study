package quickstart.service;

import org.springframework.stereotype.Service;
import quickstart.enums.RequestType;

@Service
public class CustomerService {
    public String handleREquest(RequestType requestType){
        return switch (requestType){
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };
    }
    private String handleQuery(){
        return "Handing user query...";
    }
    private String handleComplaint(){
        return "Handing user complaint...";
    }

    private String handleSuggestion(){
        return "Handling user suggestion";
    }
}
