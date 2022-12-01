package inside.controller.user;

import inside.domain.UserDTO;
import inside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserWithdrawalController {

    @Autowired
    UserService userService;

    @PostMapping("/login/withdrawal")
    public String withdrawal(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        UserDTO user = (UserDTO)session.getAttribute("loginInfo");

        userService.deleteUser(user.getUserId());

        return "redirect:/logout";
    }
}
