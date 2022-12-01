package inside.Exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class LoginExceptionAdvice {

    @ExceptionHandler
    @ResponseBody
    public String wrongID(Exception e)
    {
        log.info(e.getMessage());

        return e.getMessage();
    }


}
