package company.amazon.ood2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    class BookInfo {
        String author;
        String name;
    }

    class BookItem {
        BookInfo info;
        String id;
    }

    class Account {
        String id;
        String name;
        List<BookItem> bookItemList;
    }

    class Lending {
        Account account;
        BookItem bookItem;
    }

    class SearchNode {
        SearchNode[] children = new SearchNode[26];
        List<BookInfo> list = new ArrayList<>();
    }

    class Library {
        Map<BookInfo, List<BookItem>> bookMap = new HashMap<>();
        Map<Account, List<Lending>> lendingMap = new HashMap<>();
        SearchNode root = new SearchNode();

        public Library(List<BookInfo> infoList) {
            for (BookInfo bookInfo : infoList) {
                String name = bookInfo.name;
                SearchNode cur = root;
                for (char c : name.toCharArray()) {
                    if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new SearchNode();
                    cur = cur.children[c - 'a'];
                    cur.list.add(bookInfo);
                }
            }
        }

        public List<BookInfo> search(String prefix) {
            SearchNode cur = root;
            List<BookInfo> res = new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) return new ArrayList<>();
                cur = cur.children[c - 'a'];
                res = cur.list;
            }
            return res;
        }
    }
}
