package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;


 

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\New folder\\BDDFrameWorkPractice\\src\\test\\java\\Features\\login2.feature"
		,glue= {"stepDefination"},//provide package name
		monochrome = true,
		dryRun=false
		
		)
public class testRunnerLogInPage {


}
