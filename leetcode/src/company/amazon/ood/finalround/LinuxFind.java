package company.amazon.ood.finalround;

import java.util.ArrayList;
import java.util.List;

public class LinuxFind {
    abstract class Entry {
        String name;
    }

    class File {
        byte[] content;
        int size;
        int type;
    }

    class Directory {
        List<Entry> list = new ArrayList<>();
    }

    interface IFilter {
        boolean isValid(File file);
    }

    class SizeFilter implements IFilter{
        int size;

        public SizeFilter(int size) {
            this.size = size;
        }

        @Override
        public boolean isValid(File file) {
            return this.size == file.size;
        }
    }

    class FileFilter implements IFilter {
        List<IFilter> filters = new ArrayList<>();

        public FileFilter(List<IFilter> filters) {
            this.filters = filters;
        }

        @Override
        public boolean isValid(File file) {
            for (IFilter filter : filters) {
                if (!filter.isValid(file)) return false;
            }
            return true;
        }

        void addFIlter(IFilter filter) {
            this.filters.add(filter);
        }
    }

    class FindCommand {
        FileFilter fileFilter;

        List<File> findFiles(Directory directory) {
            List<File> res = new ArrayList<>();
            dfs(res, directory);
            return res;
        }

        private void dfs(List<File> res, Directory directory) {
            for (Entry entry : directory.list) {

            }
        }
    }
}
