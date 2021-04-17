package com.csw.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("api")
public class Demo {
    @RequestMapping("upload")
    public void folder(MultipartFile[] files, HttpServletRequest request) throws IOException {
        System.out.println("files]=" + files);
        for (MultipartFile file : files) {

            //上传文件目录
            String realPath = request.getSession().getServletContext().getRealPath("/demo");
            String fileName = file.getOriginalFilename();
            System.out.println("fileName=" + fileName);
            File uploadFile = new File(realPath, fileName);
            //判断上传文件目录是否存在，如果不存在就创建
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            file.transferTo(uploadFile);
        }

    }
}
