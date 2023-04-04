package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseURL {
    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL() {

        specification = new RequestSpecBuilder().
                setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api").
                build();
    }
}
