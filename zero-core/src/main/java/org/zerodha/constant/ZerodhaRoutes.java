package org.zerodha.constant;

import java.util.Date;
import static org.zerodha.constant.ZerodhaConstant.X_KITE_VERSION;

public class ZerodhaRoutes {

	public static final String KITE_ROOT_URL = "https://kite.zerodha.com/api";

	public static final String KITE_WEB_SOCKET_URL = "wss://ws.zerodha.com/?api_key=kitefront&user_id=USER_ID&public_token=PUBLIC_TOKEN"
			+ (new Date().getTime()) + "&user-agent=kite3-web&version="+X_KITE_VERSION;

	public static final String KITE_MARKET_WATCH = KITE_ROOT_URL + "/marketwatch";

	public static final String KITE_SESSION = KITE_ROOT_URL + "/session";

	public static final String KITE_NOTICE = KITE_ROOT_URL + "/notice";

	public static final String KITE_MARGINS = KITE_ROOT_URL + "/user/margins";

	public static final String KITE_ORDERS = KITE_ROOT_URL + "/orders";

	public static final String KITE_PORTFOLIO_HOLDINGS = KITE_ROOT_URL + "/portfolio/holdings";
	
	public static final String KITE_PORTFOLIO_POSITIONS = KITE_ROOT_URL + "/portfolio/positions";
	
	public static final String KITE_ALERTS = KITE_ROOT_URL + "/alerts";
	
	public static final String KITE_CONNECT_APPS = KITE_ROOT_URL + "/apps/connected_apps";
	
	public static final String KITE_CHARTS = "https://kitecharts-aws.zerodha.com/api/chart/TOKEN/TIME_FRAMEminute?public_token=PUBLIC_TOKEN&user_id=USER_ID&api_key=kitefront&access_token=ACCESS_TOKEN&from=FROM_DATE&to=TO_DATE&ciqrandom="+(new Date().getTime());
	
}
