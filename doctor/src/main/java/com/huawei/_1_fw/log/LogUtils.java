package com.huawei._1_fw.log;

public class LogUtils {
	// #region Const

	private static final String TEMPLATE_LOG = "[%s]%s";

	// #endregion

	// #region debug

	public static void debug(Class<?> oClazz, String strContent) {
		System.out.println(String.format(TEMPLATE_LOG, oClazz.getSimpleName(), strContent));
	}

	// #endregion

	// #region error

	public static void error(Class<?> oClazz, String strContent) {
		System.out.println(String.format(TEMPLATE_LOG, oClazz.getSimpleName(), strContent));
	}

	// #endregion
}
