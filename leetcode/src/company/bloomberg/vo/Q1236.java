package company.bloomberg.vo;

import java.util.*;

public class Q1236 {
    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        visited.add(startUrl);
        String hostName = startUrl.split("/")[2];
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            res.add(poll);
            List<String> urls = htmlParser.getUrls(poll);
            for (String url : urls) {
                if (visited.contains(url) || !url.contains(hostName)) continue;
                visited.add(url);
                queue.add(url);
            }
        }
        return res;
    }
}
