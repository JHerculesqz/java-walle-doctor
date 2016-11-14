package com.huawei._1_fw.spider;

import java.util.ArrayList;
import java.util.List;

import com.huawei._1_fw.log.LogUtils;
import com.huawei._1_fw.spider.vo.SpiderResVo;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lombok.Getter;
import lombok.Setter;

/**
 * reference:<br>
 * https://www.zhihu.com/question/31427895<br>
 * https://jsoup.org/<br>
 * 
 * @author JHercules
 *
 */
public class SpiderUtils {
	// #region Fields

	@Setter
	@Getter
	private static String dirPathStorage;

	@Setter
	@Getter
	private static String urlStartWith = "";

	@Setter
	@Getter
	private static List<SpiderResVo> result = new ArrayList<SpiderResVo>();

	// #endregion

	// #region run

	public static void run(String strDirPathStorage, String strUrlSeed, String strUrlStartWith) {
		try {
			// 1.init params
			setDirPathStorage(strDirPathStorage);
			setUrlStartWith(strUrlStartWith);
			result.clear();

			// 2.init config
			CrawlConfig config = new CrawlConfig();
			config.setCrawlStorageFolder(strDirPathStorage);
			config.setPolitenessDelay(1000);
			config.setMaxDepthOfCrawling(1);
			config.setMaxPagesToFetch(1000);
			config.setIncludeBinaryContentInCrawling(false);
			config.setResumableCrawling(false);
			PageFetcher pageFetcher = new PageFetcher(config);
			RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
			RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
			CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
			controller.addSeed(strUrlSeed);

			// 3.start
			controller.start(BasicSpider.class, 10);
		} catch (Exception e) {
			LogUtils.error(SpiderUtils.class, e.getMessage());
		}
	}
}
