package wenda.Service;

import wenda.entity.Problem;

import java.util.List;

public interface ProblemService {
    List<Problem> findall(int limit,int offset);

}
