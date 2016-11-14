package com.huawei._1_fw.spider.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SpiderResVo {
	// #region Fields

	@Setter
	@Getter
	private int docId;

	@Setter
	@Getter
	private String url;

	@Setter
	@Getter
	private String res;

	// #endregion
}
