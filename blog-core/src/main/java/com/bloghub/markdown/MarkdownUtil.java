package com.bloghub.markdown;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.vdurmont.emoji.EmojiParser;

public class MarkdownUtil {

	private static Parser parser = Parser.builder().build();
	
	public static String mdToHtml(String markdown) {
		if (StringUtils.isBlank(markdown)) {
			return "";
		}
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		String content = renderer.render(document);
		content = EmojiParser.parseToUnicode(content);

		return content;
	}
}
