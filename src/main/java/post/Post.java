package post;

import java.util.Objects;

public class Post {
        private String title;
        private String description;
        private String body;
        private String imageUrl;
        private String publishDate;
        private boolean draft;

        public Post() {
        }

        public Post(String title, String description, String body, String imageUrl, boolean draft) {
        }

        public Post(String title, String description, String body, String imageUrl, String publishDate, boolean draft) {
            this.title = title;
            this.description = description;
            this.body = body;
            this.imageUrl = imageUrl;
            this.publishDate = publishDate;
            this.draft = draft;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public boolean isDraft() {
            return draft;
        }

        public void setDraft(boolean draft) {
            this.draft = draft;

        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return draft == post.draft && Objects.equals(title, post.title) && Objects.equals(description, post.description) && Objects.equals(body, post.body) && Objects.equals(imageUrl, post.imageUrl) && Objects.equals(publishDate, post.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, body, imageUrl, publishDate, draft);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", draft=" + draft +
                '}';
    }
}

