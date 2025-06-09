package com.zzz.codesite.filter;

import com.alibaba.fastjson.JSONObject;
import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.utils.JWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/users/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        String token=request.getHeader("token");

        if(!StringUtils.hasLength(token)){
            log.info("Token不存在");
            Response responseResult=Response.error("Not Login");
            String json= JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        try{
            JWTUtils.parseJWT(token);
        }catch (Exception e){
            log.info("令牌解析失效");
            Response responseResult=Response.error("Not Login");
            String json= JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        filterChain.doFilter(request,response);
    }
}
