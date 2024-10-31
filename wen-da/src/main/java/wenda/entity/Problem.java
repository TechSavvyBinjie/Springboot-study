package wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * problem
 * @author 
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem implements Serializable {
    private Integer id;

    private String title;

    private Integer userId;

    private String content;

    private Integer answerId;

    private User user;

    private List<Answer> answers;


}