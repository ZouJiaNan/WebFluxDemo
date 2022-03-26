package com.eryi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/25 10:49
 */
public class syncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        doSomeThing(req,resp);
        System.out.println("Sync use:"+(System.currentTimeMillis()-start));
    }

    private void doSomeThing(HttpServletRequest request,HttpServletResponse response){
        try {
            TimeUnit.SECONDS.sleep(5);
            response.getWriter().append("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
