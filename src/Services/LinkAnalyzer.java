package Services;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LinkAnalyzer{
	public static Document getPage(String url) throws IOException
	{
		Document doc=null;
		try
		{
		doc = Jsoup.connect(url).timeout(10*1000).get(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doc;
	}
	public static  ArrayList<String> getAllLinks(Document src )
	{
		ArrayList<String> map = new ArrayList<String>();
		Elements links = src.select("a[href]");
		
        for (Element link : links) 
        {
           map.add(link.attr("abs:href"));
         
           
        }
        
		return map;
	}
	public static void main(String args[]) throws IOException
	{
		Document doc=getPage("https://www.computer.org/");
		ArrayList<String> str=getAllLinks(doc);
		System.out.println(str);
	}

}