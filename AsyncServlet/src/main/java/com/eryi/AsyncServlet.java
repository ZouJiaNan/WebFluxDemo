package com.eryi;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/25 11:29
 */
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        //开启异步,将请求、响应封装成异步专用的请求响应。
        AsyncContext asyncContext=req.startAsync();
        //单独拉起一条线程来异步处理业务
        CompletableFuture.runAsync(()->doSomeThing(asyncContext,asyncContext.getRequest(),asyncContext.getResponse()));
        System.out.println("Async use:"+(System.currentTimeMillis()-start));
    }

    private void doSomeThing(AsyncContext asyncContext,ServletRequest request, ServletResponse response){
        try {
            TimeUnit.SECONDS.sleep(5);
            response.getWriter().append("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //业务处理完成，回调通知异步上下文，返回异步响应
        asyncContext.complete();
    }
}
