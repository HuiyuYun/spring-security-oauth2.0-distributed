package org.yunhuiyu.security.distributed.uaa.config.AjaxSecurity;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.yunhuiyu.security.distributed.uaa.common.utils.ResultUtils;
import org.yunhuiyu.security.distributed.uaa.result.ResponseResult;
import org.yunhuiyu.security.distributed.uaa.result.ResultCodeEnum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限
 */
@Configuration
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult<Object> result = ResultUtils.fail(ResultCodeEnum.UNAUTHORIZED);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}