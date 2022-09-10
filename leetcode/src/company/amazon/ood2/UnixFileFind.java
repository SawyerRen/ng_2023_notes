package company.amazon.ood2;

import java.util.ArrayList;
import java.util.List;

public class UnixFileFind {
    abstract class Entry {
        private String name;

        public String getName() {
            return name;
        }

        public abstract boolean isDirectory();
    }

    class File extends Entry {
        private byte[] content;
        private int size;
        private int type;

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return type;
        }

        @Override
        public boolean isDirectory() {
            return false;
        }
    }

    class Directory extends Entry {
        private List<Entry> children;

        public List<Entry> getChildren() {
            return children;
        }

        @Override
        public boolean isDirectory() {
            return true;
        }
    }

    interface IFilter {
        boolean isValid(File file);
    }

    class SizeFilter implements IFilter {
        private int minSize;

        public SizeFilter(int minSize) {
            this.minSize = minSize;
        }

        @Override
        public boolean isValid(File file) {
            return file.size >= this.minSize;
        }
    }

    class TypeFilter implements IFilter {
        private int type;

        public TypeFilter(int type) {
            this.type = type;
        }

        @Override
        public boolean isValid(File file) {
            return this.type == file.getType();
        }
    }

    class FileFilter {
        List<IFilter> filters = new ArrayList<>();

        public void addToFilters(IFilter filter) {
            this.filters.add(filter);
        }

        public boolean isValid(File file) {
            for (IFilter filter : filters) {
                if (!filter.isValid(file)) return false;
            }
            return true;
        }
    }

    class FindCommand {
        public List<File> getFileWithFilter(Directory directory, FileFilter fileFilter) {
            List<File> res = new ArrayList<>();
            dfs(res, directory, fileFilter);
            return res;
        }

        private void dfs(List<File> res, Directory directory, FileFilter fileFilter) {
            for (Entry entry : directory.getChildren()) {
                if (entry.isDirectory()) {
                    dfs(res, (Directory) entry, fileFilter);
                } else {
                    if (fileFilter.isValid((File) entry)) {
                        res.add((File) entry);
                    }
                }
            }
        }
    }
}
