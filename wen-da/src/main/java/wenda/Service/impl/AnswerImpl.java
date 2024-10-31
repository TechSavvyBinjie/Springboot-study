package wenda.Service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wenda.Service.AnswerService;
import wenda.entity.Answer;
import wenda.mapper.AnswerDao;

@Service
public class AnswerImpl implements AnswerService {
    @Resource
    private AnswerDao answerDao;


    @Override
    public int addAnswer(Answer answer) {
        int Answerid=answerDao.insert(answer);
        return Answerid;
    }
}
