package org.example.expert.config;

import org.example.expert.domain.user.enums.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminLogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 어드민 사용자만 접근할 수 있는 특정 API에는 접근할 때마다 접근 로그를 기록

		// 주소 꺼내기
		String requestUri = request.getRequestURI();

		// request에서 필터에서 넣어준 attribute 꺼내기
		Long userId = (Long) request.getAttribute("userId");
		String email = (String) request.getAttribute("email");
		String stringUserRole = (String) request.getAttribute("userRole");

		UserRole userRole = UserRole.valueOf(stringUserRole);

		// admin 권한 확인
		if (!UserRole.ADMIN.equals(userRole)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "관리자 권한이 없습니다.");
			return false;
		}

		// log 출력
		log.info("ADMIN ACCESS LOG - (requestUri: {}) userId: {}, email: {}, userRole: {}",
			requestUri, userId, email, userRole);

		return true;
	}
}
