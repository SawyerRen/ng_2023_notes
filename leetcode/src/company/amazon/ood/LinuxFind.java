package company.amazon.ood;

import java.util.ArrayList;
import java.util.List;

public class LinuxFind {
    class File {
        String name;
        int size;
        int type;
        boolean isDirectory;
        File[] children;
    }

    abstract class Filter {
        abstract boolean apply(File file);
    }

    class SizeFilter extends Filter {
        int minSize;

        public SizeFilter(int minSize) {
            this.minSize = minSize;
        }

        @Override
        boolean apply(File file) {
            return file.size > minSize;
        }
    }

    class TypeFilter extends Filter {
        int type;

        public TypeFilter(int type) {
            this.type = type;
        }

        @Override
        boolean apply(File file) {
            return file.type == type;
        }
    }

    class FindCommand {
        public List<File> findWithFilters(File directory, List<Filter> filters) {
            List<File> res = new ArrayList<>();
            if (!directory.isDirectory) return null;
            dfs(res, directory, filters);
            return res;
        }

        private void dfs(List<File> res, File directory, List<Filter> filters) {
            for (File file : directory.children) {
                if (file.isDirectory) {
                    dfs(res, file, filters);
                } else {
                    boolean valid = true;
                    for (Filter filter : filters) {
                        if (!filter.apply(file)) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) res.add(file);
                }
            }
        }
    }
}
