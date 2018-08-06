package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
//@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/functionalTests/FlightSearch.feature",
				glue= "com.steps.stepDefinitions",
		        monochrome=true
		)

public class FlightSearchTestRunner extends AbstractTestNGCucumberTests{
	
    //private TestNGCucumberRunner testNGCucumberRunner;
    
   /* @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }*/
 
/*    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }*/
}
