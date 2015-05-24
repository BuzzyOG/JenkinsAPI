

package com.buzzyog.jenkinsapi;

public class JenkinsJobNotFoundException extends JenkinsException {

    public JenkinsJobNotFoundException(String s) {
        super(s);
    }

    public JenkinsJobNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}