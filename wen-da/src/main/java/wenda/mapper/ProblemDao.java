package wenda.mapper;

import wenda.entity.Problem;

import java.util.List;

public interface ProblemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    List<Problem> findAll(int limit,int offset);
}