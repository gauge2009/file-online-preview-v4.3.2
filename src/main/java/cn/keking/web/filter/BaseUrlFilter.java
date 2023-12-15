package cn.keking.web.filter;

import cn.keking.config.ConfigConstants;
import cn.keking.web.controller.OnlinePreviewController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author chenjh
 * @since 2020/5/13 18:27
 */
public class BaseUrlFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(BaseUrlFilter.class);
    private static String BASE_URL;

    public static String getBaseUrl() {
        String baseUrl;
        try {
            baseUrl = (String) RequestContextHolder.currentRequestAttributes().getAttribute("baseUrl", 0);
        } catch (Exception e) {
            baseUrl = BASE_URL;
        }
        return baseUrl;
    }


    @Override
    public void init(FilterConfig filterConfig) {

    }

/*    假设configBaseUrl存的是 "http://mobile.hrlink.com.cn:4499|http://pc.hrlink.com.cn:4433", request中有属性mode，mode="mobile",则
    baseUrl = "http://mobile.hrlink.com.cn:4499" ， mode="pc",则
     baseUrl = "http://pc.hrlink.com.cn:4433" ，请据此修改下面的方法
在ConfigConstants中配置的baseUrl是一个字符串，其中包含了多个URL，这些URL之间通过管道符(“|”)分隔。  根据请求中的mode属性来选择不同的URL作为baseUrl。
 */
//   @Override
    public void doFilterBAK(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String baseUrl;
        String configBaseUrl = ConfigConstants.getBaseUrl();

        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        //1、支持通过 http header 中 X-Base-Url 来动态设置 baseUrl 以支持多个域名/项目的共享使用
        final String urlInHeader = servletRequest.getHeader("X-Base-Url");
        if (StringUtils.isNotEmpty(urlInHeader)) {
            baseUrl = urlInHeader;
        } else if (configBaseUrl != null && !ConfigConstants.DEFAULT_BASE_URL.equalsIgnoreCase(configBaseUrl)) {
            //2、如果配置文件中配置了 baseUrl 且不为 default 则以配置文件为准
            baseUrl = configBaseUrl;
        } else {
            //3、默认动态拼接 baseUrl
            baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + servletRequest.getContextPath() + "/";
        }

        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl.concat("/");
        }

        BASE_URL = baseUrl;
        request.setAttribute("baseUrl", baseUrl);
        filterChain.doFilter(request, response);
    }


    /*    假设configBaseUrl存的是 "http://mobile.hrlink.com.cn:4499|http://pc.hrlink.com.cn:4433", request中有属性mode，mode="mb",则
        baseUrl = "http://mobile.hrlink.com.cn:4499" ， mode="pc",则
         baseUrl = "http://pc.hrlink.com.cn:4433" ，请据此修改下面的方法
    在ConfigConstants中配置的baseUrl是一个字符串，其中包含了多个URL，这些URL之间通过管道符(“|”)分隔。  根据请求中的mode属性来选择不同的URL作为baseUrl。
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String baseUrl="";
        String configBaseUrl = ConfigConstants.getBaseUrl();
        String configBaseUrl4Mobile = ConfigConstants.getBaseUrl4Mobile();
        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        final String urlInHeader = servletRequest.getHeader("X-Base-Url");
        //final String mode = servletRequest.getParameter("mode");  // 获取 mode 参数
        final String mode = servletRequest.getParameter("mode");  // 获取 type 参数
        //type=mobile
        if (StringUtils.isNotEmpty(urlInHeader)) {
            baseUrl = urlInHeader;
        } else if (configBaseUrl != null && !ConfigConstants.DEFAULT_BASE_URL.equalsIgnoreCase(configBaseUrl)) {
            // 如果配置了多个 baseUrl ，则根据 mode 参数来选择

                if (mode!=null && mode.equalsIgnoreCase("mb")) {
                    baseUrl = configBaseUrl4Mobile;
                } else {
                    baseUrl = configBaseUrl;
                }

        } else {
            baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + servletRequest.getContextPath() + "/";
        }

        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl.concat("/");
        }
        logger.info("解析得到授信地址为，urlPath：{}", baseUrl);
        BASE_URL = baseUrl;
        request.setAttribute("baseUrl", baseUrl);
        filterChain.doFilter(request, response);
    }




    @Override
    public void destroy() {

    }
}
