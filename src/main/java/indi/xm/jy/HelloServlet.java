package indi.xm.jy;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm
 * @ClassName: HelloServlet
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 14:37
 */
@WebServlet("/hello")
@Slf4j // lombok 注解
public class HelloServlet extends HttpServlet {

//    Logger log = LoggerFactory.getLogger(HelloServlet.class);


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
        System.out.println("我才是执行所有请求的入口");
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy …… ");
    }
}
