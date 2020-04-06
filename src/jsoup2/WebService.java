package jsoup2;

public class WebService {
	
	public String message1(String param)
	{
		return "news";
	}
	
	public int calc(int x,int y)
	{
		return (x+y);
	}
	
	public double calc(double x,double y)
	{
		if(x>y)
			return (x+y);
		else
			return (x-y);
	}

}
