package com.company.Exam_Rework;

public class PostController {
    private String post;
    private int id;

    public PostController() {
    }

    public PostController(String post, int id) {
        this.post = post;
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PostController{" +
                "post='" + post + '\'' +
                ", id=" + id +
                '}';
    }
}
