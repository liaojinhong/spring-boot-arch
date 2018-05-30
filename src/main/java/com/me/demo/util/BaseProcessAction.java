package com.me.demo.util;

import java.lang.reflect.Method;

import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.me.demo.common.Constants;


/**
 * 基本的ProccessAction,所有ProccessAction都必须继承它
 */
public class BaseProcessAction extends Action {
    private static final Class[] PARAM_TYPES = new Class[] {
            HttpServletRequest.class, HttpServletResponse.class };

    /**
     * 执行方法，由Struts主动调用(内置对9个基本方法的访问，否则按actionType访问）
     * 
     * @param actionMapping actionMapping
     * @param actionForm actionForm
     * @param request http请求
     * @param response http响应
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String actionType = request.getParameter("actionType");
        String forward = actionType;// forword默认等于actionType
        // 构造action实例
        // 如果有自定义的方法，请使用else if分支加入
        if (actionType == null || actionType.trim().equals("")) {
            forward = Constants.INVALID;
        } else if (actionType.equals(Constants.PREPAREQUERY)) {
            prepareQuery(request, response);
        } else if (actionType.equals(Constants.QUERY)) {
            query(request, response);
        } else if (actionType.equals(Constants.QUERYCONTINUE)) {
            queryContinue(request, response);
        } else if (actionType.equals(Constants.VIEW)) {
            view(request, response);
        } else if (actionType.equals(Constants.PREPAREINSERT)) {
            prepareInsert(request, response);
        } else if (actionType.equals(Constants.INSERT)) {
            insert(request, response);
        } else if (actionType.equals(Constants.PREPAREUPDATE)) {
            prepareUpdate(request, response);
        } else if (actionType.equals(Constants.UPDATE)) {
            update(request, response);
        } else if (actionType.equals(Constants.DELETE)) {
            delete(request, response);
        } else {
            Object[] parameters = { request, response };
            Method method = this.getClass().getMethod(actionType, PARAM_TYPES);
            method.invoke(this, parameters);
        }

        ActionForward actionForward = mapping.findForward(forward);
        actionForward = processForward(actionForward, request);
        return actionForward;
    }

    /**
     * 处理Forward，如进行险种替换等<br>
     * 例：<br>
     * 
     * <pre>
     * String path = actionForward.getPath();
     * // 如果需要按险种匹配，则进行替换
     * if (path.indexOf('$') &gt; -1) {
     *     // 新的actionForward复制原有的actionForward，然后进行替换处理
     *     ActionForward riskActionForward = new ActionForward(actionForward);
     *     // 获取用户
     *     HttpSession session = request.getSession();
     *     PrpDuserDto user = (PrpDuserDto) (session.getAttribute(&quot;user&quot;));
     *     // 替换路径
     *     path = StringUtils.replace(path, &quot;$&quot;, user.getCurrentRiskCode());
     *     riskActionForward.setPath(path);
     *     return riskActionForward;
     * }
     * </pre>
     * 
     * 
     * @param actionForward 原始的Forward
     * @param request 原始的request
     * @return 新的ActionForward
     */
    protected ActionForward processForward(ActionForward actionForward,
            HttpServletRequest request) {
        return actionForward;
    }

    /**
     * 准备查询
     * 
     * @param request HTTP请求
     * @param response
     * @throws Exception
     */
    public void prepareQuery(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 查询
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void query(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 查询Continue
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void queryContinue(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 查看
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void view(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 准备插入
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void prepareInsert(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 插入
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 准备更新
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void prepareUpdate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 更新
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }

    /**
     * 删除
     * 
     * @param request HTTP请求
     * @param response HTTP响应
     * @throws Exception
     */
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        throw new UnavailableException("This method unavailable now!");
    }
}