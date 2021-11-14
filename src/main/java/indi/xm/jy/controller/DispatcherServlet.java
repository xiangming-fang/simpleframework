package indi.xm.jy.controller;

import indi.xm.jy.controller.frontend.MainPageController;
import indi.xm.jy.controller.superadmin.HeadLineOperationController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.controller
 * @ClassName: DispatcherServlet
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:54
 */
@Slf4j
@WebServlet("/") // 拦截所有web请求
// "/" 不会对jsp请求的拦截
// "/*" 会对jsp请求的拦截
// servlet 里 对 .jsp 的请求做了特殊处理
public class DispatcherServlet extends HttpServlet {
    @Override // 在创建之后，就一直存在tomcat容器里，只初始化一次
    public void init() throws ServletException {
        System.out.println("初始化servlet……");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("debug log ……");

        String name = "我的简易框架";
        req.setAttribute("name",name);
        // 转发
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        System.out.println("request path is: " + servletPath);
        String method = req.getMethod();
        System.out.println("request method is: " + method);
        if (servletPath == "/frontend/getmainpageinfo" && method == "GET"){
            new MainPageController().getMainPageInfo(req,resp);
        }
        else if (servletPath == "/superadmin/addheadline" && method == "POST"){
            new HeadLineOperationController().addHeadLine(req,resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy …… ");
    }
}
