package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//we need RunWith options to run cucumber with junit
//junit dependency.... to execute the test
@RunWith(Cucumber.class)
//cucumber options decide what to execute, where to execute
@CucumberOptions(
        //features we use to provide the path of the feature files
        features = "src/test/resources/features/",
        //glue is the keyword we use to find the gherkin step def
        //we provide  the path of steps package where we have all step defs
        glue = "steps",
        //dry run stops the actual execution when set to true
        //it will (scan) all the steps definitions and provide if there is any step def missing
        //false >> to execute the code .. back it by default       //true scan
                                                                  //false excute
        dryRun = false,
        //tags = "@sprint1 and @sprint4"           allow as execute based on specific sprint && type of test
        //  tags = "@sprint1 or @sprint5 or @sprint2 or @sprint6"
        tags = "@regression",
        plugin ={"pretty"}
)
public class RunnerClass {
}
