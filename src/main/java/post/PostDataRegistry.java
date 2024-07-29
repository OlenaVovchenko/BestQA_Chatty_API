package user;

import post.Post;

public class PostDataRegistry {
    public static Post createDefaultPost() {
        Post post = new Post();
        post.setTitle("Example Title");
        post.setDescription("Example Description");
        post.setBody("This is the main content of the post.");
        post.setImageUrl("http://example.com/image.jpg");
//        post.setPublishDate(LocalDateTime.now());
        post.setDraft(true);
        return post;
    }

    public static Post getInvalidPost() {
        Post post = new Post();
        post.setTitle("Example Title");
        post.setDescription(null);
        post.setBody("This is the main content of the post.");
        post.setImageUrl("http://example.com/image.jpg");
//        post.setPublishDate(LocalDateTime.now());
        post.setDraft(true);
        return post;
    }

    public static Post getUpdatedPost() {
        Post post = new Post();
        post.setTitle("Example updated Title");
        post.setDescription("Example updated Description");
        post.setBody("Updated main content of the post.");
        post.setImageUrl("http://example.com/image.jpg");
//        post.setPublishDate(LocalDateTime.now());
        post.setDraft(true);
        return post;

    }

    public static Post getUpdatedPost(String id) {
        Post post = new Post();
        post.setTitle("Updated Title with ID: " + id);
        post.setDescription("Example updated Description with ID: " + id);
        post.setBody("Updated main content of the post with ID: " + id);
        post.setImageUrl("http://example.com/image.jpg");
        post.setDraft(true);
        return post;


    }
}