package com.zhiyou100.ssh.video.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
@SuppressWarnings("all")
public class MyInterceptor02 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object obj1 = ActionContext.getContext().getSession().get("ad");
		//System.out.println(11);
		//System.out.println(obj1);
		if(obj1 != null){
			System.out.println(111);
			String invoke = invocation.invoke();
			return invoke;
		}
		return "admin";
	}

}
