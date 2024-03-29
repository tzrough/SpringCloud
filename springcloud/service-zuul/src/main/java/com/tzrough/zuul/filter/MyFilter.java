package com.tzrough.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class MyFilter extends ZuulFilter
{

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 过滤器的类型
     *
     * pre          路由之前
     * route        路由之时
     * post         路由之后
     * error        发送错误调用
     *
     **/
    @Override
    public String filterType()
    {
        return "pre";
    }

    /**
     * 过滤顺序
     **/
    @Override
    public int filterOrder()
    {
        return 0;
    }

    /**
     * 可以加逻辑, 是否要过滤
     **/
    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 可以很复杂, 包括查sql nosql 判断是否有权限访问
     **/
    @Override
    public Object run() throws ZuulException
    {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s>>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("token");

        if(accessToken == null)
        {
            logger.warn("token is empty");

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try
            {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e)
            {

            }

            return null;
        }

        logger.info("ok");
        return null;
    }
}
