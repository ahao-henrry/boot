package com.ahao.spring.boot.jdbc.service.impl;

import com.ahao.spring.boot.jdbc.mapper.UserMapper;
import com.ahao.spring.boot.jdbc.service.IUserService;
import com.ahao.spring.boot.jdbc.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author 25771
 * @since 2019/9/7 16:50
 **/
@Service
public class UserServiceImpl implements IUserService, Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random UPPER_CASE_RANDOM = new Random();
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final Random LOWER_CASE_RANDOM = new Random();
    private static final int[] NAME_LEN_RANGE = {3, 4, 5, 6, 7, 8};
    private static final Random NAME_LEN_RANDOM = new Random();
    private static final Random GENDER_RANDOM = new Random();
    private volatile Integer taskCount;
    private static final ThreadPoolExecutor POOL_EXECUTOR =
            new ThreadPoolExecutor(10, 10,
                    10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(4000),
                    Executors.defaultThreadFactory(), (r, executor) -> LOGGER.warn("--** some task discard..."));

    // @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    public UserServiceImpl(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public UserServiceImpl(Integer taskCount, UserMapper userMapper) {
        this.taskCount = taskCount;
        this.userMapper = userMapper;
    }

    @Override
    public Integer addOne(UserVO userVO) {
        return userMapper.addOne(userVO);
    }

    @Override
    public Integer addBatch(UserMapper userMapper, Integer count) {
        POOL_EXECUTOR.execute(new UserServiceImpl(count, userMapper));
        return count;
    }

    private Integer getAge() {
        int i = GENDER_RANDOM.nextInt(150);
        return i == 0 ? getAge() : i;
    }

    private Integer getGender() {
        return GENDER_RANDOM.nextInt(2);
    }

    private String getName() {
        String firstName = nameGenerator();
        String lastName = nameGenerator();
        String name = firstName + " " + lastName;
        return name;
    }

    private String nameGenerator() {
        int upperCaseIndex = UPPER_CASE_RANDOM.nextInt(25);
        char upperCase = UPPER_CASE.charAt(upperCaseIndex);
        int firstNameLen = NAME_LEN_RANGE[NAME_LEN_RANDOM.nextInt(5)];
        StringBuffer firstName = new StringBuffer();
        firstName.append(upperCase);
        for (int i = 0; i < firstNameLen; i++) {
            int lowerCaseIndex = LOWER_CASE_RANDOM.nextInt(25);
            char lowerCase = LOWER_CASE.charAt(lowerCaseIndex);
            firstName.append(lowerCase);
        }
        return firstName.toString();
    }

    @Override
    public UserVO findById(int id) {
        if (1 == id) {
            throw new IllegalArgumentException("param illegal.");
        }
        return userMapper.findById(id);
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < taskCount; i++) {
            String name = getName();
            Integer gender = getGender();
            Integer age = getAge();
            UserVO userVO = new UserVO();
            userVO.setName(name);
            userVO.setGender(gender);
            userVO.setAge(age);
            userMapper.addOne(userVO);
            count++;
        }
        LOGGER.info("--** count is : {}", count);
    }
}
