package testSpec

import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by himanshushivhare on 07-09-2015.
 */
class TestNgDemoReport {

    String msg = "Hello"

    @Test(groups = "Dsimple")
    public void takeSurvey(){
    println(msg+"1")

    Assert.assertEquals(1,1)
    }

    @Test(groups = "Dsimple")
    public void takeSurvey1(){
        println(msg+"2")

        Assert.assertEquals(2,3)
    }

    @Test
    public void testSurvey2(){
        println(msg+"3")

        Assert.assertEquals(3,3)
    }

    @Test
    public void testSurvey3(){
        println(msg+"3")

        Assert.assertEquals(3,4)
    }

}
