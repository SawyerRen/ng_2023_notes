package company.amazon.ood2;

import java.util.ArrayList;
import java.util.List;

public class UnixFind {
    abstract class Entry {
        private String name;

        public String getName() {
            return name;
        }

        abstract boolean isDirectory();
    }

    enum FileType {
        PDF, JPEG, DOC
    }

    class File extends Entry {
        private byte[] content;
        private int size;
        private FileType type;

        public byte[] getContent() {
            return content;
        }

        public int getSize() {
            return size;
        }

        public FileType getType() {
            return type;
        }

        @Override
        boolean isDirectory() {
            return false;
        }
    }

    class Directory extends Entry {
        List<Entry> list = new ArrayList<>();

        @Override
        boolean isDirectory() {
            return true;
        }
    }

    interface IFilter {
        boolean isValid(File file);
    }

    class SizeFilter implements IFilter {
        int size;

        public SizeFilter(int size) {
            this.size = size;
        }

        @Override
        public boolean isValid(File file) {
            return file.size >= this.size;
        }
    }

    class TypeFilter implements IFilter {
        FileType type;

        public TypeFilter(FileType type) {
            this.type = type;
        }

        @Override
        public boolean isValid(File file) {
            return file.type == this.type;
        }
    }

    class FileFilter {
        List<IFilter> filters;

        public FileFilter(List<IFilter> filters) {
            this.filters = filters;
        }

        public boolean isValid(File file) {
            for (IFilter filter : filters) {
                if (!filter.isValid(file)) return false;
            }
            return true;
        }
    }

    class FindCommand {
        public List<File> findFile(Directory directory, FileFilter fileFilter) {
            List<File> res = new ArrayList<>();
            dfs(res, directory, fileFilter);
            return res;
        }

        private void dfs(List<File> res, Directory directory, FileFilter fileFilter) {
            for (Entry entry : directory.list) {
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
