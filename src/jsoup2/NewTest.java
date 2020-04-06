package jsoup2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	@DataProvider
	public Object[][] mydatasource()
	{
	return new Object[][]{
	{327.01},{137.4},{12.52}
	};
	}
	
  @Test
  public void test1() {
	  String excepted = "new";
	  String actual;
	  WebService mytest1 = new WebService();
	  actual = mytest1.message1("abc");
	  //断言
	  Assert.assertEquals(actual, excepted);
  }
  @Test
  public void test2() {
	  int excepted = 10;
	  int actual;
	  WebService mytest1 = new WebService();
	  actual = mytest1.calc(2, 8);
	  //断言
	  Assert.assertEquals(actual, excepted);
  }
  @Test(dataProvider="mydatasource")
  public void test3(double x) {
	  double excepted = 10;
	  double actual;
	  WebService mytest1 = new WebService();
	  actual = mytest1.calc(x, 137.4);
	  //断言
	  Assert.assertEquals(actual, excepted);
  }
}
