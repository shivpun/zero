package org.zerodha.util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.zerodha.constant.ZerodhaConstant;
import org.zerodha.constant.ZerodhaRoutes;

public class ZerodhaUtil {

	public String websocket(String userId, String publicToken) {
		StringBuilder sb = new StringBuilder(ZerodhaRoutes.KITE_WEB_SOCKET_URL
														  .replace("USER_ID", userId)
														  .replace("PUBLIC_TOKEN", publicToken));
		return sb.toString();
	}

	public String chart(String userId, String publicToken, String accessToken, String token) {
		StringBuilder sb = new StringBuilder(ZerodhaRoutes.KITE_CHARTS
														  .replace("USER_ID", userId)
														  .replace("PUBLIC_TOKEN", publicToken)
														  .replace("ACCESS_TOKEN", accessToken)
														  .replace("TOKEN", token));
		return sb.toString();
	}

	public WebSocketHttpHeaders addWebSocketHeaderCookie(String cookie) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cookie", cookie);
		headers.add("Host", "ws.zerodha.com");
		headers.add("Origin", "https://kite.zerodha.com");
		headers.add("User-Agent", ZerodhaConstant.USER_AGENT);
		headers.add("Upgrade", "websocket");
		WebSocketHttpHeaders socketHttpHeaders = new WebSocketHttpHeaders(headers);
		socketHttpHeaders.setSecWebSocketExtensions(WebSocketExtension.parseExtensions("permessage-deflate; client_max_window_bits"));
		return socketHttpHeaders;
	}
}
