package com.ww.step_definitions;

import com.ww.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


        @Before
        public void setup(Scenario scenario) {
            System.out.println("::: Starting Automation:::");
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }


        @After
        public void tearDown(Scenario scenario) {
                
        String projectId = "imposing-timer-420716";
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        BigQueryOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build().getService();
        
        String query = "SELECT name FROM `imposing-timer-420716.test_dataset.test-table`";

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).build());
        queryJob = queryJob.waitFor();

        if (queryJob == null) {
            throw new Exception("job no longer exists");
        }
        if (queryJob.getStatus().getError() != null) {
            throw new Exception(queryJob.getStatus().getError().toString());
        }
        TableResult result = queryJob.getQueryResults();
        for (FieldValueList row : result.iterateAll()) {
            Integer count = row.get("f0_").getNumericValue().intValue();

        }
        
            if(scenario.isFailed()){
               // byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                //scenario.attach(screenshot,"image/png",scenario.getName());
            }

            Driver.closeDriver();
            System.out.println(":::(^_^) End of test execution (*_*):::");
        }



}
