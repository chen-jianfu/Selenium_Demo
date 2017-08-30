import com.cjf.testdata.TestDataFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jeff on 2017/8/30.
 */
public class CalcTest {
    private Calc calc;

    @BeforeClass
    public void init(){
      calc = new Calc();
    }
//    @DataProvider(name ="calc_data")
//    public Object[][] calcTestData(){
//        Object[][] objs = new Object[][]{
//                {10,20,30},
//                {30,10,20},
//                {30,30,60}
//        };
//        return objs;
//    }
    @Test
    public void testCompute1(){
        int x = 10,y =20;
        int expected = 30;
    //    Calc calc = new Calc();
        int actual = calc.computer(x,y);
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCompute2(){
        int x = 30,y =10;
        int expected = 20;
     //   Calc calc = new Calc();
        int actual = calc.computer(x,y);
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCompute3(){
        int x = 30,y =30;
        int expected = 60;
     //   Calc calc = new Calc();
        int actual = calc.computer(x,y);
        Assert.assertEquals(actual,expected);
    }
    @Test(dataProviderClass = TestDataFactory.class,dataProvider = "calc_test_data")
    public void testCompute4(int x,int y, int expected){
        int actual = calc.computer(x,y);
        Assert.assertEquals(actual,expected);
    }
}
