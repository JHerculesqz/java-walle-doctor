package com.huawei._1_fw.spider;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.huawei._1_fw.log.LogUtils;
import com.huawei._1_fw.spider.vo.SpiderResVo;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class BasicSpider extends WebCrawler {
	// #region Const

	private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");

	// #endregion

	// #region shouldVisit

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		if (IMAGE_EXTENSIONS.matcher(href).matches()) {
			return false;
		}

		return href.startsWith(SpiderUtils.getUrlStartWith());
	}

	// #endregion

	// #region visit

	@Override
	public void visit(Page page) {
		try {

			int docid = page.getWebURL().getDocid();
			String url = page.getWebURL().getURL();
			// String domain = page.getWebURL().getDomain();
			// String path = page.getWebURL().getPath();
			// String subDomain = page.getWebURL().getSubDomain();
			// String parentUrl = page.getWebURL().getParentUrl();
			// String anchor = page.getWebURL().getAnchor();

			// LogUtils.debug(BasicSpider.class, "docid:" + docid);
			// LogUtils.debug(BasicSpider.class, "url:" + url);
			// LogUtils.debug(BasicSpider.class, "domain:" + domain);
			// LogUtils.debug(BasicSpider.class, "subDomain:" + subDomain);
			// LogUtils.debug(BasicSpider.class, "path:" + path);
			// LogUtils.debug(BasicSpider.class, "parentUrl:" + parentUrl);
			// LogUtils.debug(BasicSpider.class, "anchor:" + anchor);

			if (page.getParseData() instanceof HtmlParseData) {
				HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
				String text = htmlParseData.getText();
				// String html = htmlParseData.getHtml();
				// Set<WebURL> links = htmlParseData.getOutgoingUrls();
				SpiderResVo oSpiderResVo = new SpiderResVo();
				oSpiderResVo.setDocId(docid);
				oSpiderResVo.setUrl(url);
				oSpiderResVo.setRes(text);
				SpiderUtils.getResult().add(oSpiderResVo);
				FileUtils.write(new File(SpiderUtils.getDirPathStorage() + "\\" + docid + ".txt"), text);
				// LogUtils.debug(BasicSpider.class, "text:" + text);
				// LogUtils.debug(BasicSpider.class, "html:" + html.length());
				// LogUtils.debug(BasicSpider.class, "links.size:" +
				// links.size());
			}

			// Header[] responseHeaders = page.getFetchResponseHeaders();
			// if (responseHeaders != null) {
			// logger.debug("Response headers:");
			// for (Header header : responseHeaders) {
			// LogUtils.debug(BasicSpider.class, "\t" + header.getName() + ":" +
			// header.getValue());
			// }
			// }
		} catch (IOException e) {
			LogUtils.error(BasicSpider.class, e.getMessage());
		}
	}

	// #endregion
}
