package company.amazon.q500;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q588 {
    class File {
        String name;
        StringBuilder content = new StringBuilder();
        TreeMap<String, File> files = new TreeMap<>();

        public File(String name) {
            this.name = name;
        }
    }

    class FileSystem {
        File root = new File("/");

        public FileSystem() {

        }

        private File findFile(String path, boolean create) {
            File cur = root;
            String[] split = path.split("/");
            for (String s : split) {
                if (s.equals("")) continue;
                if (!cur.files.containsKey(s)) {
                    if (create) cur.files.put(s, new File(s));
                    else return null;
                }
                cur = cur.files.get(s);
            }
            return cur;
        }

        public List<String> ls(String path) {
            File file = findFile(path, false);
            List<String> res = new ArrayList<>();
            if (file == null) return null;
            if (file.content.length() > 0) res.add(file.name);
            else res.addAll(file.files.keySet());
            return res;
        }

        public void mkdir(String path) {
            findFile(path, true);
        }

        public void addContentToFile(String filePath, String content) {
            File file = findFile(filePath, true);
            file.content.append(content);
        }

        public String readContentFromFile(String filePath) {
            File file = findFile(filePath, true);
            return file.content.toString();
        }
    }
}
