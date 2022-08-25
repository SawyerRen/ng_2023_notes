package company.amazon.ood.stackoverflow;

import java.util.Date;
import java.util.List;

public class StackOverflow {
    class Account {
        int id;
        String password;
        String name;
        String address;
        String email;
        String phone;
        int reputation;
        List<Badge> badges;

        public boolean createQuestion(Question question) {
            return true;
        }

        public boolean createTag(Tag tag) {
            return true;
        }
    }

    class Badge {
        String name;
    }

    class Tag {
        String name;
        int dailyAccessCount;
        int weeklyAccessCount;
    }

    class Notification {
        int id;
        Date createdAt;
        String content;

        void sendNotification() {
        }
    }

    class Question {
        String title;
        String description;
        int viewCount;
        int voteCount;
        Date createdAt;
        Date updatedAt;
        Account account;
        List<Comment> comments;
        List<Answer> answers;
    }

    class Comment {
        private String text;
        private Date creationTime;
        private int flagCount;
        private int voteCount;
        private Account askingMember;

        public void incrementVoteCount() {
        }
    }

    class Answer {
        private String answerText;
        private boolean accepted;
        private int voteCount;
        private int flagCount;
        private Date creationTime;
        private Account creatingMember;
    }

}
