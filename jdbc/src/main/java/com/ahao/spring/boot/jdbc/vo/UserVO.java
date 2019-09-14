package com.ahao.spring.boot.jdbc.vo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 25771
 * @since 2019/9/7 15:45
 **/
public class UserVO {

    private Integer id;
    @NotNull(message = "name can't be null")
    private String name;
    @Range(min = 0, max = 2, message = "gender must be 0,1,2")
    private Integer gender;
    @Range(min = 1, max = 150, message = "age must be 1-150")
    private Integer age;
    private List<DogVO> dogs;
    private CarVO car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<DogVO> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogVO> dogs) {
        this.dogs = dogs;
    }

    public CarVO getCar() {
        return car;
    }

    public void setCar(CarVO car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", dogs=" + dogs +
                ", car=" + car +
                '}';
    }
}
