package com.ww.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
               "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },
        features = {
                "src/test/resources/features/findWorkshop/FindStudio.feature"  // copy path of feature file from the content root
        },
        glue = "com/ww/step_definitions" ,
        dryRun = false,
        tags = "@regression",
        publish = true
)

public class TestRunner {
}
