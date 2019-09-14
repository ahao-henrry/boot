package com.ahao.spring.boot.jdbc.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ahao
 * @since 2019/6/12 22:03
 **/
public class ResultDTO {
    private String code;

    private String message;

    private Object data;

    public ResultDTO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static String success(Object data) {
        return successJackson(data);
    }

    public static String error(Object data) {
        return errorJackson(data);
    }

    /*private static String successFastJson(Object data) {
        ResultDTO resultDTO = new ResultDTO("200", "success", data);
        return JSON.toJSONString(resultDTO);
    }

    public static String errorFastJson(Object data) {
        ResultDTO resultDTO = new ResultDTO("500", "failed", data);
        return JSON.toJSONString(resultDTO);
    }*/

    private static String successJackson(Object data) {
        ResultDTO resultDTO = new ResultDTO("200", "success", data);
        return object2JacksonString(resultDTO);
    }

    private static String errorJackson(Object data) {
        ResultDTO resultDTO = new ResultDTO("500", "fail", data);
        return object2JacksonString(resultDTO);
    }

    /**
     * 使用Jackson 序列化的话可以利用它的一些注解来实现特殊的格式化,
     * 毕竟spring 官方都使用的Jackson
     * */
    private static String object2JacksonString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}