package wenda.Service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wenda.Service.ProblemService;
import wenda.entity.Problem;
import wenda.mapper.ProblemDao;

import java.util.List;
@Service
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemDao problemDao;
    @Override
    public List<Problem> findall(int limit,int offset) {
        List <Problem> problems=problemDao.findAll(limit,offset);
        return problems;
    }
}
