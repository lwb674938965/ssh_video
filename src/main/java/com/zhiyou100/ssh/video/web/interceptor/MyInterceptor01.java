package com.zhiyou100.ssh.video.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
@SuppressWarnings("all")
public class MyInterceptor01 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object obj = ActionContext.getContext().getSession().get("_front_user");
		//System.out.println(111);
		//System.out.println(obj);
		if(obj != null){
			System.out.println(111);
			String invoke = invocation.invoke();
			return invoke;
		}
		return "logout";
	
		
	}

}
