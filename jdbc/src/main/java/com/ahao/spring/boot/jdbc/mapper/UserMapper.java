package com.ahao.spring.boot.jdbc.mapper;

import com.ahao.spring.boot.jdbc.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 25771
 * @since 2019/9/7 16:46
 **/
@Mapper
public interface UserMapper {
    Integer addOne(UserVO userVO);

    UserVO findById(int id);
}
