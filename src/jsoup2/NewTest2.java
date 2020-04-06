package jsoup2;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class NewTest2 {
  @Test(dataProvider = "dp")
  public void logindiscuz(String username, String password) {
	  String url =  "http://localhost:8080/path/login.jsp";
	  String rawBody = "username="+username+"&password="+password+;//输入测试的变量
	  jsoupTest mypost = new jsoupTest();
	  String reponse = mypost.postBody(url,rawBody);
	  Reporter.log(reponse.toString());//日志
	  Assert.assertTrue(reponse.contains(""));//登录成功提示
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "admin" },
      new Object[] { "cloud", "cloud" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
