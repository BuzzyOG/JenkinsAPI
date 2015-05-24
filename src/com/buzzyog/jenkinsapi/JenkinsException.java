

package com.buzzyog.jenkinsapi;

public class JenkinsException extends RuntimeException {

    public JenkinsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    protected JenkinsException(String s) {
        super(s);
    }
}