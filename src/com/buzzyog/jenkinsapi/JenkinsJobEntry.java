

package com.buzzyog.jenkinsapi;

public class JenkinsJobEntry {

    private String name;
    private String url;
    private String color;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Result getResult() {
        return Result.getByIdent(color);
    }
}