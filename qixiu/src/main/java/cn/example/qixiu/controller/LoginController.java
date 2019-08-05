package cn.example.qixiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)
        		&& "123".equals(username)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败

            map.put("msg","用户名密码错误");
            return  "login";
        }

    }
    /**
	 * 用户注销
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		//ModelAndView result = new ModelAndView("login_new");
		HttpSession session = request.getSession();//获取当前session
		if(session!=null){
			//User user = (User)session.getAttribute("yh");//从当前session中获取用户信息
			session.invalidate();//关闭session
		}
		return "redirect:/";
	}
}
