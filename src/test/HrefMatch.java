package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatch {
	
	private String urlStr;
	
	public HrefMatch(String urlStr){
		this.urlStr = urlStr;
	}
	
	public String getWebCharSet() throws Exception, IOException{
		
		URL url = new URL(urlStr);
		InputStreamReader in = new InputStreamReader(url.openStream(),"gb2312");
		BufferedReader reader = new BufferedReader(in);
		StringBuilder input = new StringBuilder();
		
		int ch;
		char[] chArray = new char[5024];
		
		String str = null;
		while((str = reader.readLine()) != null){
			input.append(str);
		}
		
		
		String patternString = "charset=[\\s\"a-zA-Z0-9-]+";
		Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		
		String charSet = null;
		
		while(matcher.find()){
			//粗定位
			int start = matcher.start();
			int end = matcher.end();
			String match = input.substring(start,end);
			
			patternString = "=[\\s\"a-zA-Z0-9-]+";
			pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
			matcher = pattern.matcher(match);
			
			//细定位
			while(matcher.find()){
				start = matcher.start();
				end = matcher.end();
				charSet = match.substring(start,end);
			}
		}
		
		String charSetTrim = charSet.trim().substring(1);
		
		int charSetStart = 0;
		int charSetEnd = charSetTrim.length();
		
		//如果字符集使用了引号
		if(charSetTrim.startsWith("\"")){
			charSetStart++;
		}
		if(charSetTrim.endsWith("\"")){
			charSetEnd--;
		}
		
		return charSetTrim.substring(charSetStart,charSetEnd);
		
			
	}
	
	public void searchWebCotent(String keyword,String charSet) throws Exception{
		
		URL url = new URL(urlStr);
		InputStreamReader in = new InputStreamReader(url.openStream(),charSet);
		BufferedReader reader = new BufferedReader(in);
		
		StringBuilder input = new StringBuilder();
		
		int ch;
		char[] chArray = new char[100];
	
		String str = null;
		while((str = reader.readLine()) != null){
			input.append(str);
		}
		
		String patternString = keyword;
		Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		
		System.out.println(input);
		
		while(matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			String match = input.substring(start,end);
			System.out.println(match);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
//		String urlStr = "http://www.baidu.com";
//        String keyword = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s>";
//        keyword =  "<[aA]\\s*(href=[^>]+)>(.*?)</[aA]>";   
//
//		HrefMatch hrefMath = new HrefMatch(urlStr);
//		
//		String charSet = hrefMath.getWebCharSet();
//		System.out.println(charSet);
//		
//		hrefMath.searchWebCotent(keyword, charSet);
//		
	   InetAddress[] address = InetAddress.getAllByName("localhost");
		
		for (InetAddress a:address){
			byte[] b = a.getAddress();
			for(byte buffer:b){
				System.out.print(buffer);
				System.out.print(".");
			}
			System.out.println();
		}
		
		}
		
}
