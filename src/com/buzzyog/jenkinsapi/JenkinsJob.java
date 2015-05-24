
package com.buzzyog.jenkinsapi;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.FileNotFoundException;

public class JenkinsJob {

    private String jobName;
    private JenkinsJobEntry jobEntry;
    private JenkinsJobHealth health;
    private JenkinsJobBuild latestBuild;

    public JenkinsJob(String jobName, JenkinsJobEntry jobEntry) {
        this.jobName = jobName;
        this.jobEntry = jobEntry;
        this.health = getHealth();
        this.latestBuild = getLatestBuild();
    }

    public String getJobName() {
        return jobName;
    }

    public JenkinsJobEntry getJobEntry() {
        return jobEntry;
    }

    public JenkinsJobBuild getLatestBuild() {
        if (this.latestBuild == null) {
            try {
                latestBuild = Nexus.JSON.read(Unirest.get(Jenkins.getJenkins().JENKINS_URL + "job/" + jobName + "/api/json"), "lastBuild", JenkinsJobBuild.class);
            } catch (UnirestException e) {
                if (e.getCause() instanceof FileNotFoundException) {
                    throw new JenkinsJobNotFoundException("Failed to locate Jenkins API!", e);
                }
                throw new JenkinsJobException("Failed to connect to Jenkins API!", e);
            }
        }
        return latestBuild;
    }

    public JenkinsJobHealth getHealth() {
        if (this.health == null) {
            try {
                return Nexus.JSON.read(Unirest.get(Jenkins.getJenkins().JENKINS_URL + "job/" + jobName + "/api/json"), "healthReport", JenkinsJobHealth[].class)[0];
            } catch (UnirestException e) {
                if (e.getCause() instanceof FileNotFoundException) {
                    throw new JenkinsJobNotFoundException("Failed to locate Jenkins API!", e);
                }
                throw new JenkinsJobException("Failed to connect to Jenkins API!", e);
            }
        }
        return health;
    }
}