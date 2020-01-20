package com.spes.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.spes.model.UserVO;
import com.spes.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService uservice;

	// preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// session ��ü�� ������
		HttpSession session = request.getSession();
		// loginó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
		Object obj = session.getAttribute("login");
		System.out.println("login");
		System.out.println(session.getAttribute("login"));
		System.out.println(obj);

		if (obj == null) { // �α��ε� ������ ���� ���...
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); // ����� ���� ��Ű�� �����´�.
			if (loginCookie != null) { // ��Ű�� �����ϴ� ���(������ �α��ζ� ������ ��Ű�� �����Ѵٴ� ��)
				// loginCookie�� ���� �������� -> ��, �����س� ����Id�� ��������
				String sessionId = loginCookie.getValue();
				// ����Id�� checkUserWithSessionKey�� ������ ������ �α��������� �ִ��� üũ�ϴ� �޼��带 ���ļ�
				// ��ȿ�ð��� > now() �� �� ���� ��ȿ�ð��� ������ �����鼭 �ش� sessionId ������ ������ �ִ� ����� ������ ��ȯ�Ѵ�.
				UserVO user = uservice.checkSessionLogin(sessionId);

				if (user != null) { // �׷� ����ڰ� �ִٸ� ������ ����.
					session.setAttribute("login", user);
					return true;
				}
			}
			// ���� �Ʒ��� �α��ε� �ȵ��ְ� ��Ű�� �������� �ʴ� ���ϱ� �ٽ� �α��� ������ ���������� �ȴ�.
			// �α����� �ȵǾ� �ִ� ���������� �α��� ������ �ٽ� ��������(redirect)
			response.sendRedirect("/login");
			return false; // ���̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��
		}

		// preHandle�� return�� ��Ʈ�ѷ� ��û uri�� ���� �ǳ� �ȵǳĸ� �㰡�ϴ� �ǹ���
		// ���� true���ϸ� ��Ʈ�ѷ� uri�� ���� ��.
		return true;
	}

	// ��Ʈ�ѷ��� ����ǰ� ȭ���� �������� ������ ����Ǵ� �޼���
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
