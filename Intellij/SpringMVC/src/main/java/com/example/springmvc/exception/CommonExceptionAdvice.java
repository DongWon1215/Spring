package com.example.springmvc.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String exceptionNum (NumberFormatException exception)
    {
        log.info(exception.getMessage());

        return "NumberFormatException";
    }

//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    public String exceptionNum (NullPointerException exception)
//    {
//        log.info(exception.getMessage());
//
//        return "NullPointerException";
//    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionNum (Exception exception)
    {
        log.info(exception.getMessage());

        StackTraceElement[] stackTraceElements = exception.getStackTrace();

        StringBuffer buffer = new StringBuffer("<h1>");
        buffer.append(exception.getMessage() + "</h1>");
        buffer.append("<hr>");

        for(StackTraceElement element : stackTraceElements)
        {
            buffer.append("<div>" + element + "</div>");
        }

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound()
    {
        return "custom404";
    }
}
