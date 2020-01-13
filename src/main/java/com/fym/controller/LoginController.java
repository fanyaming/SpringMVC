package com.fym.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * Created by lenovo on 2020/1/13.
 */
@Controller
public class LoginController {
   /* //1.使用原始的方式,通过请求对象来获取参数
    @RequestMapping("/login")
    public void login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }
    //2.使用同名形参的方式(表单的参数名要和形参的相同,这种方式适用于参数数量较少的时候)
    //表单的参数名和形参的名称不同,就使用requestParam注解
    @RequestMapping("/login")
    public void login(@RequestParam("username") String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
    //3.将参数封装到对象中,使用对象来接收
    @RequestMapping("/login")
    public void login(User u){
        System.out.println(u.getPassword());
        System.out.println(u.getUsername());
    }
    //当前台是使用地址栏传递参数的时候.例如使用restful风格的时候
    //如localhost/login/admin/1234
    @RequestMapping("/login/{id}")
    public void login(@PathVariable("id") Long id ){
        System.out.println(id);
    }*/
   //这里不能使用File来接收,因为没有无参的构造器
   @RequestMapping("/upload")
    public ModelAndView upload(MultipartFile file){
       System.out.println(file.getName());//表单中参数的名称
       System.out.println(file.getContentType());//文件的类型
       System.out.println(file.getOriginalFilename());//文件的真实名称
       System.out.println(file.getSize());//获取文件的大小
       //需要获取到文件上传的那个文件
       FileOutputStream os = null;
       try{
           //需要将文件保存到服务器的某个目录下
           //名字需要通过UUID来重新命名
           String lastName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
           String startName  = UUID.randomUUID().toString();
           String fileName = startName+lastName;
           System.out.println(fileName);
           os = new FileOutputStream(new File("E:/file",fileName));
           InputStream is = file.getInputStream();
           IOUtils.copy(is, os);
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           if(os!=null){
               try {
                   os.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       ModelAndView mv = new ModelAndView("upload.jsp");
       return mv;
    }
    @RequestMapping(value="/download")
    @ResponseBody//该方法响应内容全都有response控制,(springmvc不会做任务事情）
    public void download(HttpServletResponse response) throws Exception{
        response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
        OutputStream out = response.getOutputStream();
        FileInputStream in= new FileInputStream("E:\\file\\1.jpg");
        IOUtils.copy(in, out);
        in.close();
        out.close();
    }
}
