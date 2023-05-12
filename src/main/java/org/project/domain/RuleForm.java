package org.project.domain;

public class RuleForm {
    private String contents;

    public RuleForm() {
    }

    public RuleForm(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "RuleForm{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
