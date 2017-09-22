package org.spring.springcloud.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务过滤
 * 在服务网关中定义过滤器只需要继承ZuulFilter抽象类
 * 实现其定义的四个抽象函数就可对请求进行拦截与过滤。
 * Date: 2017/9/22
 * Time: 下午5:35
 * Author: xieqinghe .
 */
public class MyZuulFilter extends ZuulFilter {

    //过滤器的具体逻辑。需要注意，这里我们通过
    //context.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
    // 然后通过context.setResponseStatusCode(401)设置了其返回的错误码，
    // 当然我们也可以进一步优化我们的返回，比如，通过context.setResponseBody(body)
    // 对返回body内容进行编辑等。
    @Override
    public Object run() {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        Object accessToken = request.getParameter("id");
        if (accessToken==null){
            System.out.println("出现错误");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        System.out.println("请求合法");
        return null;
    }

    @Override
    public String filterType() {

//        返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
//        pre：可以在请求被路由之前调用
//        routing：在路由请求时候被调用
//        post：在routing和error过滤器之后被调用
//        error：处理请求时发生错误时被调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //通过int值来定义过滤器的执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
        return true;
    }
}
