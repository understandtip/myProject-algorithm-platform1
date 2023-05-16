package org.project.controller;

import org.project.exception.BusinessException;
import org.project.exception.SystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public Result doSystemException(SystemException ex, ModelAndView modelAndView){
        //1.记录日志  //2.发送消息给运维  //3.发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)//可以对非法操作进行提示和警醒
    @ResponseBody
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doOtherException(Exception ex,Model model ){
        //1.记录日志  //2.发送消息给运维  //3.发送邮件给开发人员,ex对象发送给开发人员
        /* model.addAttribute("error",new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！"));
        return "notFound.html";*/
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}