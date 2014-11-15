package com.crossp.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import com.crossp.jpa.domain.StoreApp;

public class Appstore {
	public final static String appstorePrefix = "https://itunes.apple.com/app/id";
	
	public StoreApp getApp(String appstoreId) {
		return null;
	}
	
	private StoreApp getFromDB(String appstoreId) {
		return null;
	}
	
	private StoreApp getFromWeb(String appstoreId) {
		StoreApp appItem = null;
		
		try {
			URL url = new URL(appstorePrefix + appstoreId);
			URLConnection conn = url.openConnection();
			
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			String inputLine;

			// save to this filename
			String fileName = "f:/tmp/tmp.html";
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			// use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Done");
			
			//conn.getInputStream();
			
//			DocumentBuilderFactory builderFactory =
//			        DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = builderFactory.newDocumentBuilder();
//			Document document = builder.parse(conn.getInputStream());
//			XPath xPath = XPathFactory.newInstance().newXPath();
//			String expression = "[@property='og:title']";
//			String title = xPath.compile(expression).evaluate(document);
//			Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
//			node.getAttributes();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return appItem;
	}
	
	public static void main(String[] args) throws Exception {
//		Appstore store = new Appstore();
//		store.getFromWeb("929040357");
		Document document = Jsoup.connect("https://itunes.apple.com/cn/app/id653350791").get();
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "[@property='og:title']";
		String title = xPath.compile(expression).evaluate(document);
		Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
	}
}
