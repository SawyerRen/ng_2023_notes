package company.amazon.q500;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q588 {
    class File {
        String name;
        StringBuilder content;
        TreeMap<String, File> directoryFiles;

        public File(String name) {
            this.name = name;
            content = new StringBuilder();
            directoryFiles = new TreeMap<>();
        }
    }

    class FileSystem {
        File root;

        public FileSystem() {
            root = new File("/");
        }

        public List<String> ls(String path) {
            File file = findFile(path, false);
            if (file == null) return null;
            List<String> files = new ArrayList<>();
            if (file.content.length() > 0) files.add(file.name);
            else files.addAll(file.directoryFiles.keySet());
            return files;
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

        private File findFile(String path, boolean create) {
            String[] split = path.split("/");
            File cur = root;
            for (String s : split) {
                if (s.equals("")) continue;
                if (!cur.directoryFiles.containsKey(s)) {
                    if (create) {
                        cur.directoryFiles.put(s, new File(s));
                    } else {
                        return null;
                    }
                }
                cur = cur.directoryFiles.get(s);
            }
            return cur;
        }

    }
}
