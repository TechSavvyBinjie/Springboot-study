package wenda.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wenda.entity.Problem;
import wenda.entity.User;

import java.util.List;

public interface UserProblemsMapper extends BaseMapper<User> {
    @Select("select p.* from User u LEFT JOIN problem p  ON p.user_id=u.id where u.id=#{userId} ")
    List<Problem> selectCoursesByStudentId(int userId);

}
