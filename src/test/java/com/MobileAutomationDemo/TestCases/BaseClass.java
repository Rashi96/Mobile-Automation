package com.MobileAutomationDemo.TestCases;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.MobileAutomationDemo.Utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	
	public static AppiumDriverLocalService service;
	static ReadConfig readconfig = new ReadConfig();
	public static String appName = readconfig.getAppName();
	public static String deviceName = readconfig.getDeviceName();
	public static AndroidDriver driver;
	
	@BeforeTest
	public void startServer() {
		
		boolean flag = checkIfServerIsRunnning(4723);
		if(!flag){
			
			Runtime runtime = Runtime.getRuntime();
			try {
	    	
				runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
				Thread.sleep(10000);
	        
			} catch (IOException | InterruptedException e) {
	    	
				e.printStackTrace();
	        
			}
		}
	    
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Configuration\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	@BeforeClass
	public void setCapabilities() throws IOException, InterruptedException{
	//public AndroidDriver setCapabilities() throws MalformedURLException{
		
		startEmulator();
		
		File appDir = new File("Apps");
		File app = new File(appDir,appName);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//return driver;
		
	}
	
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {

			serverSocket = new ServerSocket(port);
			
			serverSocket.close();

		} catch (IOException e) {
			
			isServerRunning = true;

		} finally {

			serverSocket = null;

		}

		return isServerRunning;

	}
	
	@AfterTest
	public void stopServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static File captureScreen(String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		return target;
		
	}
	
//	public static void getScreenshot(String s) throws IOException{
//		
//		String date = new SimpleDateFormat("yyyy:MM:dd:hh:mm").format(new Date());
//		File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"/Screenshots/"+s+".png"));
//		
//	}

}
