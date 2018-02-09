package com.dmy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Zuul过滤器
 * 实现了在请求被路由之前检查HttpServletRequest中是否有accessToken参数，
 * 若有就进行路由，若没有就拒绝访问，返回401 Unauthorized错误
 */

public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        /*filterType：过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
         这里定义为pre，代表会在请求被路由之前执行。*/
        return "pre";
    }

    @Override
    public int filterOrder() {
//        过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*判断该过滤器是否需要被执行。这里我们直接返回了true，
        因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。*/
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("send {} request to {}"+request.getMethod()+request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            System.out.println("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.setResponseBody(new String("鉴权失败".getBytes("ISO-8859-1"),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
