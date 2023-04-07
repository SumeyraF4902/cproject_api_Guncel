package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseURL {
    protected RequestSpecification specification;

    @BeforeTest
    public void setUpBaseURL() {

        specification = new RequestSpecBuilder().
                setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api").
                build();
    }
}
