package org.zerodha.constant;

import java.util.Date;

public class ZerodhaRoutes {

	public static final String KITE_ROOT_URL = "https://kite.zerodha.com/api";

	public static final String KITE_WEB_SOCKET_URL = "wss://ws.zerodha.com/?api_key=kitefront&user_id={USER_ID}&public_token={PUBLIC_TOKEN}"
			+ (new Date().getTime()) + "&user-agent=kite3-web&version=1.13.5";

	public static final String KITE_MARKET_WATCH = KITE_ROOT_URL + "/marketwatch";

	public static final String KITE_SESSION = KITE_ROOT_URL + "/session";

	public static final String KITE_NOTICE = KITE_ROOT_URL + "/notice";

	public static final String KITE_MARGINS = KITE_ROOT_URL + "/user/margins";

	public static final String KITE_ORDERS = KITE_ROOT_URL + "/orders";

	public static final String KITE_PORTFOLIO_HOLDINGS = KITE_ROOT_URL + "/portfolio/holdings";
	
	public static final String KITE_PORTFOLIO_POSITIONS = KITE_ROOT_URL + "/portfolio/positions";
	
	public static final String KITE_ALERTS = KITE_ROOT_URL + "/alerts";
	
	public static final String KITE_CONNECT_APPS = KITE_ROOT_URL + "/apps/connected_apps";
	
	public static final String KITE_CHARTS = "https://kitecharts-aws.zerodha.com/api/chart/{TOKEN}/{TIME_FRAME}minute?public_token={PUBLIC_TOKEN}&user_id={USER_ID}&api_key=kitefront&access_token={ACCESS_TOKEN}&from={FROM}&to={TO}&ciqrandom="+(new Date().getTime());

	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";
}
