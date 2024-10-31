package wenda.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wenda.Service.ProblemService;
import wenda.common.ResponseResult;
import wenda.entity.Problem;
import wenda.mapper.ProblemDao;
import wenda.mapper.UserProblemsMapper;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/home")
public class ProblemController {
    private final ProblemService problemService;
    private final ProblemDao problemDao;
    private final UserProblemsMapper userProblemsMapper;
    @GetMapping("/problems")
    private ResponseResult findall(@RequestParam int limit,int offset){
        List<Problem> all = problemService.findall(limit,offset);
        return ResponseResult.builder().code(200).msg("测试").data(all).build();
    }
    @GetMapping("/problem")
    private ResponseResult findall(@RequestParam int id){
        List<Problem> all = userProblemsMapper.selectCoursesByStudentId(id);
        return ResponseResult.builder().code(200).msg("测试").data(all).build();
    }


    @PostMapping ("/adds")
    private ResponseResult addProblem(@RequestBody Problem problem){
        int changes=problemDao.insert(problem);
        return ResponseResult.builder().code(200).msg("测试").data(changes).build();
    }
    @PostMapping ("/delete")
    private ResponseResult deleteProblem(@RequestParam int id){
        int changes=problemDao.deleteByPrimaryKey(id);
        return ResponseResult.builder().code(200).msg("测试").data(changes).build();
    }
}
