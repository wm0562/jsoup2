package jsoup2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupTest {
	public Document jsoup_get1(String url) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			return(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}

	public Document jsoup_get2(String url,String param) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			Connection conn = Jsoup.connect(url);
			conn.data("wd",param);
			doc = conn.get();
			return(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}
	
	public Document jsoup_post1(String url,String param) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			Connection conn = Jsoup.connect(url);
			conn.data("username","cloud");//jsoup不能rawdata
			conn.data("password",param);
			doc = conn.post();
			return(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}
	
	public String postBody(String url, String rawBody){
		HttpURLConnection conn = null;
		PrintWriter pw = null ;
		BufferedReader rd = null ;
		StringBuilder sb = new StringBuilder ();
		String line = null ;
		String response = null;
		try {
		conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setReadTimeout(20000);
		conn.setConnectTimeout(20000);
		conn.setUseCaches(false);
		conn.connect();
		pw = new PrintWriter(conn.getOutputStream());
		pw.print(rawBody);
		pw.flush();
		rd = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while ((line = rd.readLine()) != null ) {
		sb.append(line);
		}
		response = sb.toString();
		} catch (MalformedURLException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}finally{ 
		try {
		if(pw != null){
		pw.close();
		}
		if(rd != null){
		rd.close();
		}
		if(conn != null){
		conn.disconnect();
		}
		} catch (IOException e) {
		e.printStackTrace();
		}}
		return response;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsoupTest my = new jsoupTest();
		//System.out.println(my.jsoup_get1("http://www.baidu.com"));
		System.out.println(my.jsoup_get2("http://www.baidu.com/s", "loadrunner"));
		//System.out.println(my.jsoup_post1("http://127.0.0.1/defect/login.php", "loadrunner"));
//		Document doc = my.jsoup_get2("http://www.baidu.com", "loadrunner");
//		if(doc.toString().contains("title1"))
//			System.out.println("pass");
//		else
//			System.out.println("fail");
		Document doc = my.jsoup_get1("http://www.baidu.com");
		Elements element = doc.select(".lb");
		System.out.println(element.get(0));
		
	}

}
