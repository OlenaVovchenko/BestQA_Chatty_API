package post;

public class PostDataRegistry {
    public static Post createDefaultPost() {
        Post post = new Post();
        post.setTitle("Example Title");
        post.setDescription("Example Description");
        post.setBody("This is the main content of the post.");
        post.setImageUrl("http://example.com/image.jpg");
        post.setDraft(true);
        return post;
    }
    public  static Post getInvalidPost(){
        Post post = new Post();
        post.setTitle("Example Title");
        post.setDescription(null);
        post.setBody("This is the main content of the post.");
        post.setImageUrl("http://example.com/image.jpg");
        post.setDraft(true);
        return post;
    }
}