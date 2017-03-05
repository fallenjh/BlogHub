package com.bloghub.markdown;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractTemplateView;

public class MarkdownView extends AbstractTemplateView {

	@Override
	protected void renderMergedTemplateModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PrintWriter writer = response.getWriter();
		response.addHeader("Content-type", "text/html");
		writer.append("<!doctype html>\n");
        writer.append("<html>\n");
        writer.append("<head>\n");
//        writer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
        writer.append("<link rel=\"stylesheet\" href=\"highlightjs/9.9.0/styles/atom-one-dark.css\">\n");
        writer.append("<script src=\"highlightjs/9.9.0/highlight.js\"></script>\n");
        writer.append("<script src=\"highlightjs/9.9.0/registerLanguage.min.js\"></script>\n");
        writer.append("<script>hljs.initHighlightingOnLoad();</script>\n");
        writer.append("</head>\n");
        writer.append("<body>\n");
        writer.append(getHtmlFromMarkdown());
        writer.append("</body>\n</html>");
	}

	private String getHtmlFromMarkdown() throws URISyntaxException, IOException {
        String templatePath = "templates/" + getUrl();
        URL templateUrl = MarkdownView.class.getClassLoader().getResource(templatePath);
        Path path = Paths.get(templateUrl.toURI());

        String markdown = new String(Files.readAllBytes(path));

        return MarkdownUtil.mdToHtml(markdown);
    }
}
