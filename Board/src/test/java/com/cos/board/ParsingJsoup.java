package com.cos.board;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ParsingJsoup {

	public static String getYoutubeParse(String URL) {
		String result = "";
		String parsing = "";
		if (URL.contains("=")) {
			int index = URL.indexOf("=");
			parsing = URL.substring(index + 1);

		} else {
			int index = URL.lastIndexOf("/");
			parsing = URL.substring(index + 1);

		}
		result = result + parsing;
		return result;

	}

	@Test
	public void parseTest() {
		String data = "https://<a href=\"http://www.youtube.com/watch?v=nM0xDI5R50E\""
				+ ">www.youtube.com/watch?v=nM0xDI5R50E</a></p><p>&nbsp;</p><p>&nbsp;</p>"
				+ "<p>ㄹㅈㄷㅎㄷㅈ<img src=\"/resources/editor/upload/2018_11_21_121802.png\"</p>";
		Document doc = Jsoup.parse(data);
		// System.out.println(doc);
		Elements a_tag = doc.select("a"); // Elements 는 배열이라 size체크 가능
		// System.out.println(a_tag.size());
		int a_tagSize = a_tag.size();
		if (a_tag.size() > 0) {
			for (int i = 0; i < a_tag.size(); i++) {
				if (a_tag.get(i).attr("href")
						.contains("https://www.youtube.com")
						|| a_tag.get(i).attr("href")
								.contains("https://www.youtu.be")||
								a_tag.get(i).attr("href")
								.contains("http://www.youtube.com")
								|| a_tag.get(i).attr("href")
										.contains("http://www.youtu.be")) {
					System.out.println("유튜브 영상 링크가 존재합니다.");
					String href = a_tag.get(i).attr("href");
					String result = getYoutubeParse(href);

					String iframe = "<iframe id=\"player\" type=\"text/html\" width=\"90%\" height=\"409\" src=\"http://www.youtube.com/embed/"
							+ result
							+ "\" frameborder=\"0\" webkitallowfullscreen=\"\" mozallowfullscreen=\"\" allowfullscreen=\"\"></iframe>";

					a_tag.get(i).before(iframe);
					

				}
			}
		}
		System.out.println(doc);
	}
}
