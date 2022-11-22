package com.example.springmvc.Controller;

import domain.Report;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@Log4j2
@RequestMapping("/report")
public class FileUploadController {

    @GetMapping
    public String getReport()
    {

        return "report/reportForm";
    }

    // Requestparam을 이용하는 방법
    @PostMapping("/submit1")
    public String result1(
            @RequestParam("snum")String snum,
            @RequestParam("sname") String sname,
            @RequestParam("report") MultipartFile report,
            HttpServletRequest request,
            Model model) throws IOException {

        //web 경로
        String uploadURI = "/uploadfile/report";    //http://localhost:8080/uploadfile/report

        //시스템 경로 (폴더 위치,절대경로)
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

        log.info(dirRealPath);

        report.transferTo(new File(dirRealPath, report.getOriginalFilename()));

        model.addAttribute("snum",snum);
        model.addAttribute("sname",sname);
        model.addAttribute("fileName",report.getOriginalFilename());



        return "report/submit1";
    }

    // HttpServletRequest를 이용하는 방법
    @PostMapping("/submit2")
    public String result2(MultipartHttpServletRequest request, Model model) throws IOException
        {
            String snum = request.getParameter("snum");
            String sname = request.getParameter("sname");
            MultipartFile report = request.getFile("report");

            //web 경로
            String uploadURI = "/uploadfile/report";    //http://localhost:8080/uploadfile/report

            //시스템 경로 (폴더 위치,절대경로)
            String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

            log.info(dirRealPath);

            report.transferTo(new File(dirRealPath, report.getOriginalFilename()));

            model.addAttribute("snum",snum);
            model.addAttribute("sname",sname);
            model.addAttribute("fileName",report.getOriginalFilename());

            return "report/submit2";
    }

    // Command Object를 이용하는 방법
    @PostMapping("/submit3")
    public String result3(Report report,HttpServletRequest request, Model model) throws IOException {
        String uploadURI = "/uploadfile/report";    //http://localhost:8080/uploadfile/report

        //시스템 경로 (폴더 위치,절대경로)
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

        report.getReport().transferTo(new File(dirRealPath,report.getReport().getOriginalFilename()));

        model.addAttribute("snum",report.getSnum());
        model.addAttribute("sname",report.getSname());
        model.addAttribute("fileName",report.getReport().getOriginalFilename());

        return "report/submit3";
    }
}
