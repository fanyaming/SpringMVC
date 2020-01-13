package com.fym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2020/1/13.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/hello")
    public void index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        httpServletRequest.setAttribute("msg","hello2");
        httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
