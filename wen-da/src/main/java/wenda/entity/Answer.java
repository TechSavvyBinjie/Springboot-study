package wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * answer
 * @author 
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer implements Serializable {
    private Integer id;

    private Integer answerUserId;

    private Integer answerProblemId;

    private String answerContent;

    private User user;
}