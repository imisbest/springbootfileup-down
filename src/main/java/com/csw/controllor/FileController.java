package com.csw.controllor;

import com.csw.entity.File1;
import com.csw.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/10/25.
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("showAll")
    public String showAll(HttpServletRequest request) {
        List<File1> fileList = fileService.queryAll();
        request.setAttribute("fileList", fileList);
        return "showAllFiles";
    }

    @RequestMapping("up")
    public String upload(MultipartFile bb, HttpServletRequest request) throws IOException {
        if (bb.getOriginalFilename().equals("")) {
            return "redirect:/file/showAll";
        }
        System.out.println("文件名//：" + bb.getOriginalFilename());
        System.out.println("文件类型//:" + bb.getContentType());
        System.out.println("文件大小//:" + bb.getSize());
        System.out.println("name//:" + bb.getName());
        // System.out.println("后缀//:" + bb.getOriginalFilename().substring(bb.getOriginalFilename().lastIndexOf(".")));
        String realPath = request.getSession().getServletContext().getRealPath("/upDown");
        System.out.println("realPath//:" + realPath);

        String newFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + UUID.randomUUID().toString().replace("-", "");
        String fileNameSuffix = "." + FilenameUtils.getExtension(bb.getOriginalFilename());
        String newFileName = newFileNamePrefix + fileNameSuffix;
//日期目录
        String dateDirString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("dateDirString//:" + dateDirString);
        File dateDir = new File(realPath, dateDirString);
        System.out.println("dateDir//:" + dateDir);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        bb.transferTo(new File(dateDir, newFileName));
        String id = UUID.randomUUID() + "";
        String oname = bb.getOriginalFilename();
        String nname = newFileName;
        String z_file = oname.substring(oname.lastIndexOf("."));
        String path = dateDirString;
        String sizes = bb.getSize() + "";
        String type = bb.getContentType();
        String istrue = bb.getOriginalFilename();
        String count = "0";
        fileService.addFile(new File1(id, oname, nname, z_file, path, sizes, type, istrue, count));

        /* fileService.addFile();*/
        return "redirect:/file/showAll";
    }

    @RequestMapping("down")
    // @ResponseBody
    public String down(String fileName, String id, String openStyle, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");

        System.out.println("id" + id);
        System.out.println("openStyle//:" + openStyle);
        String aa = openStyle;
        if (openStyle == null) {
            openStyle = "attachment";
        } else {
            openStyle = "inline";
        }
        String realPath = request.getSession().getServletContext().getRealPath("/upDown");
        File1 ff = fileService.queryById(id);
        File file = new File(realPath, ff.getPath() + "/" + ff.getNname());
        FileInputStream is = new FileInputStream(file);
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        System.out.println("this is down");
        /**
         * 更新次数
         */
        System.out.println("aa//:" + aa);
        if (aa == null) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
            //File1 ff2 = fileService.queryById(id);
            ff.setCount(Integer.parseInt(ff.getCount()) + 1 + "");
            fileService.updateCount(ff);
        }
        /**
         * ajax回调
         */
//        String json = new Gson().toJson(ff);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().print(json);
       /* File1 ff2=fileService.queryById(id);
        return "showAllFiles?ff2=ff2";*/
        return null;
    }

    @RequestMapping("delete")
    public String delete(String id, HttpServletRequest request) {

        /**
         *
         */
        String realPath = request.getSession().getServletContext().getRealPath("/upDown");
        File1 ff = fileService.queryById(id);
        String path = realPath + "\\" + ff.getPath() + "\\" + ff.getNname();
        System.out.println("path//:" + path.replace("\\", "\\\\"));
        String patha = path.replace("\\", "\\\\");
        File aa = new File(patha);
        aa.delete();
        /**
         *
         */
        fileService.delete(id);
        return "redirect:/file/showAll";

    }

}

