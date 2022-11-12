package com.PRACTICE.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin ={"html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features ="src/test/resources",
        glue = "com/PRACTICE/step_def",
        tags = "@regression",
        dryRun = false
)



public class CukesRunner {

}
