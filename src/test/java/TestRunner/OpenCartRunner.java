package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features=".\\src\\test\\resources\\Features\\Login.feature",
                 glue={"com.CucumberParellel.StepDefinitions"} ,
                 plugin={"pretty","html:target/cucumber-reports"},
                 monochrome=true,
                 publish=true)
                 
public class OpenCartRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	
	public Object[][] scenarios() {
        return super.scenarios();
    }

	

}
