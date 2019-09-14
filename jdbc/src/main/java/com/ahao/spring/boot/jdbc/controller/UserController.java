package com.ahao.spring.boot.jdbc.controller;

import com.ahao.spring.boot.jdbc.mapper.UserMapper;
import com.ahao.spring.boot.jdbc.service.IUserService;
import com.ahao.spring.boot.jdbc.vo.ResultDTO;
import com.ahao.spring.boot.jdbc.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 25771
 * @since 2019/9/7 16:52
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    public String addOne(@RequestBody @Validated UserVO userVO, BindingResult bindingResult) {
        LOGGER.info("--** addOne, userVO is {}", userVO);
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            return ResultDTO.error(message);
        }
        return ResultDTO.success(iUserService.addOne(userVO));
    }

    @PostMapping("/add/{count}")
    public String addBatch(@PathVariable("count") Integer count) throws InterruptedException {
        LOGGER.info("--** addBatch, count is {}", count);
        Integer effectiveCount = iUserService.addBatch(userMapper, count);
        return ResultDTO.success(effectiveCount);
    }

    @GetMapping("/get/{id}")
    public String findById(@PathVariable("id") Integer id) {
        LOGGER.info("--** findById, id is {}", id);
        if (null == id) {
            return ResultDTO.error("id can't be null");
        }
        return ResultDTO.success(iUserService.findById(id));
    }
}
