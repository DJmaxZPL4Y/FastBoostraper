package fr.djmaxz.FastBoostraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FastVersion {

	@SuppressWarnings("unused")
	private String actualVersion, latestVersion, url;
	private boolean isRelease, isUpdated;
	
	public FastVersion (String actualVersion, String url){
	
		this.actualVersion = actualVersion;
		this.url = url;
		
		try {
			parseVersionFromUrl(new URL(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(toNumber(actualVersion) >= toNumber(latestVersion)){
			isUpdated = true;
		}else{
			isUpdated = false;
		}
		
	}	
	
	private void parseVersionFromUrl(URL url) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String version = reader.readLine();
		if(version.startsWith("release")){
			this.isRelease = true;
			this.latestVersion = version.substring(8);
		}else{
			this.isRelease = false;
			this.latestVersion = version.substring(7);
		}
        reader.close();
	}
	
	public int toNumber(String version){
		if(version.matches("[0-9]+[.][0-9]+[.][0-9]+")){
			int cut = version.lastIndexOf(".");
			return Integer.parseInt(version.substring(0, cut).replace(".", ""));
		}else{
			System.out.println("Error can't parse version !");
			return 0;
		}
	}
	
	public String getActualVersion(){
		return this.actualVersion;
	}
	
	public String getLatestVersion(){
		return this.latestVersion;
	}
	
	public boolean isRelease(){
		return this.isRelease;
	}
	
	public boolean isUpdated(){
		return this.isUpdated;
	}
	
}
