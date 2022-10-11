package company.bloomberg.goodluck;

import java.util.*;

public class Q1236 {
    private interface HtmlParser {
        public List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = startUrl.split("/")[2];
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startUrl);
        visited.add(startUrl);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            res.add(poll);
            List<String> urls = htmlParser.getUrls(poll);
            for (String url : urls) {
                if (visited.contains(url) || !url.contains(hostName)) continue;
                queue.add(url);
                visited.add(url);
            }
        }
        return res;
    }
}
