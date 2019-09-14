package com.ahao.spring.boot.jdbc.service;

import com.ahao.spring.boot.jdbc.mapper.UserMapper;
import com.ahao.spring.boot.jdbc.vo.UserVO;

/**
 * @author 25771
 * @since 2019/9/7 16:49
 **/
public interface IUserService {
    Integer addOne(UserVO userVO);

    Integer addBatch(UserMapper userMapper, Integer count) throws InterruptedException;

    UserVO findById(int id);
}
