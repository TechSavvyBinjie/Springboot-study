package wenda.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wenda.Service.AnswerService;
import wenda.common.ResponseResult;
import wenda.entity.Answer;
import wenda.mapper.AnswerDao;

@RestController
@AllArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerDao answerDao;
    @PostMapping("/add")
    public ResponseResult add(@RequestBody Answer answer){
        int AnswerId=answerService.addAnswer(answer);
        return ResponseResult.builder().code(200).data(AnswerId).msg("成功回复").build();
    }
    @PostMapping("/delete")
    public ResponseResult add(@RequestParam int id){
        int AnswerId=answerDao.deleteByPrimaryKey(id);
        return ResponseResult.builder().code(200).data(AnswerId).msg("成功删除").build();
    }
}
