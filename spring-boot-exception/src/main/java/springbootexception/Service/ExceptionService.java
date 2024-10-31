package springbootexception.Service;

import org.springframework.stereotype.Service;
import springbootexception.exception.ServerException;

@Service
public class ExceptionService{/**
 * 模拟未登录异常     */
public void unAuthorizedError(){throw new ServerException("没有登录");}/**     *模拟系统异常     */
 public void systemError(){
     throw new ServerException("系统异常");}
}
