package com.ahao.spring.boot.core.fileupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ahao
 * @since 2019/8/21 21:41
 **/
@RestController
@RequestMapping("/file")
public class FileUpload {

    @PostMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile[] files) {
        System.out.println("--**length : "+files.length);
        for (MultipartFile file : files) {
            System.out.println("--**file name : " + file.getName());
            System.out.println("--**file getSize : " + file.getSize());
            System.out.println("--**file getOriginalFilename : " + file.getOriginalFilename());
        }
        return "suc";
    }
}
