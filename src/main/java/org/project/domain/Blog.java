package org.project.domain;

public class Blog {
            private Long bid;
            private String title;
            private String content;
            private String outline;
            private String input;
            private String output;

    public Blog() {
    }

    public Blog(Long bid, String title, String content, String outline, String input, String output) {
        this.bid = bid;
        this.title = title;
        this.content = content;
        this.outline = outline;
        this.input = input;
        this.output = output;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", outline='" + outline + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
