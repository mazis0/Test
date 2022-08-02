package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
@CucumberOptions(
        glue = {
                "com.qa.hooks",
                "com.qa.stepdef"
        },
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json"},
        tags = "@producer"
)
public class RunCukesTest {



}
