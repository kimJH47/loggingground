package core.loggingground.presentation.interceptor;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);
	private static final String REQUEST_ID = "X-REQUEST-ID";
	private static final String URL = "url";
	@Override
	public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
		@NonNull Object handler) throws
		Exception {
		MDC.put("request", request.getRequestURI());

		//nginx 에서 요청 ID 제공, 제공이 안되는 환경일 시 임의로 생성
		String requestId = request.getHeader(REQUEST_ID);
		if (requestId == null || requestId.isEmpty()) {
			requestId = UUID.randomUUID().toString();
		}

		MDC.put(REQUEST_ID, requestId);
		MDC.put(URL, request.getRequestURI());

		return true;
	}

	@Override
	public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
		@NonNull Object handler,
		ModelAndView modelAndView) throws Exception {
		MDC.clear();
	}
}
