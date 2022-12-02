package inside.Exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
@RequestMapping("error/registfail")
public class RegisterExceptionAdvice {

    @ExceptionHandler
    @ResponseBody
    public String wrongID(Exception e)
    {
        log.info(e.getMessage());
        log.info("안돼 가입시켜줄 마음 없어 돌아가");

        return e.getMessage();
    }


}
