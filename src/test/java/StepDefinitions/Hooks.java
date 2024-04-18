package StepDefinitions;

import Utilities.GWD_old;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void Before(){
       // System.out.println("Senaryo basladi");
    }

    @After

    public void after(Scenario senaryo){

        if (senaryo.isFailed()){

            // aşağıdaki bölüm sadece extend report plugini devrede ise açılır
//            TakesScreenshot ts=(TakesScreenshot) GWD.getDriver();
//            byte[] hafizadakiHali= ts.getScreenshotAs(OutputType.BYTES);
//            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");

        }

        GWD_old.quitDriver();
    }

}
