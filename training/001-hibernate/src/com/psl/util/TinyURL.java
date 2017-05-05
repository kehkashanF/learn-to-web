package com.psl.util;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

//Blog - http://www.ultimateprogrammingtutorials.info

public class TinyURL {
	public static Proxy getProxy() {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
				"ngproxy.persistent.co.in", 8080));
		return proxy;
	}

	public String getUrl(String Link) {
		String tUrl = "";
		try {

			URL url = new URL("http://tinyurl.com/api-create.php?url=" + Link);
			HttpURLConnection conn = (HttpURLConnection) url
					.openConnection(getProxy());
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			String output;
			while ((output = br.readLine()) != null) {
				tUrl += output;
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return tUrl;
	}
}