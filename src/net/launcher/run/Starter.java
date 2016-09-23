package net.launcher.run;
import com.denvys5.JRE;
import net.launcher.components.Frame;
import net.launcher.utils.BaseUtils;
import net.launcher.utils.ProcessUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Starter
{
	private static ArrayList<String> params = new ArrayList<String>();
	public static void main(String[] args) throws Exception
	{
		try {
			String jarpath = Starter.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			int memory = BaseUtils.getPropertyInt("memory", 512);
			if(JRE.isJavaInstalled()){
				if(System.getProperty("os.name").toLowerCase().startsWith("win")){
					if(System.getProperty("sun.arch.data.model").equals("32")){
						params.add(BaseUtils.getAssetsDir()+"/assets/JRE/Win/bin/java");
					}else{
						params.add(BaseUtils.getAssetsDir()+"/assets/JRE/Win64/bin/java");
					}
				}else if(System.getProperty("os.name").toLowerCase().startsWith("mac")){
					params.add(System.getProperty("java.home")+"/bin/java");
				}else{
					params.add(BaseUtils.getAssetsDir()+"/assets/JRE/Linux/bin/java");
				}
			}else{
				params.add(System.getProperty("java.home")+"/bin/java");
			}
			/*if(System.getProperty("sun.arch.data.model").equals("32") && (memory>1536)) {
				memory = 1536;
				BaseUtils.setProperty("memory", memory);
			}*/
			if(System.getProperty("sun.arch.data.model").equals("64") && (memory<1024)) {
				memory = 1024;
				BaseUtils.setProperty("memory", memory);
			}
			params.add("-Xmx"+memory+"m");
			params.add("-XX:MaxPermSize=128m");

			/*params.add("Djavax.net.ssl.keyStoreType=pkcs12");
			params.add("Djavax.net.ssl.trustStoreType=jks");
			params.add("Djavax.net.ssl.keyStore=cert.spc");
			params.add("Djavax.net.ssl.trustStore=gridserver.keystore");
			params.add("Djavax.net.debug=ssl");
			params.add("Djavax.net.ssl.keyStorePassword=$PASS");
			params.add("Djavax.net.ssl.trustStorePassword=$PASS");*/

			/*System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
			System.setProperty("javax.net.ssl.trustStoreType", "jks");
			System.setProperty("javax.net.ssl.trustStoreType", "cert.spc");
			System.setProperty("javax.net.ssl.keyStore", "gridserver.keystore");
			System.setProperty("javax.net.ssl.trustStore", "ssl");
			System.setProperty("javax.net.ssl.keyStorePassword", "$PASS");
			System.setProperty("javax.net.ssl.trustStorePassword", "$PASS");*/
			System.setProperty("javax.net.ssl.trustStore", Paths.get(".").toAbsolutePath().normalize().toString()+"cert.spc");


			if(BaseUtils.getPropertyInt("threads") == 0)BaseUtils.setProperty("threads", 1);
			params.add("-XX:ParallelGCThreads=" + BaseUtils.getPropertyInt("threads"));

			if(System.getProperty("os.name").toLowerCase().startsWith("mac"))
			{
				params.add("-Xdock:name=Minecraft");
				params.add("-Xdock:icon="+BaseUtils.getAssetsDir().toString()+"/favicon.png");
			}
			params.add("-classpath");
			params.add(jarpath);
			params.add(Mainclass.class.getCanonicalName());
			params.add("true");
			
			ProcessBuilder pb = new ProcessBuilder(params);
			pb.directory(new File(BaseUtils.getAssetsDir().toString()));
			Process process = pb.start();
			if (process == null) throw new Exception("Launcher can't be started!");
			new ProcessUtils(process).print();
		} catch (IOException e){
			System.out.println("We crashed :)");
				try{
					String jarpath = Starter.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
					int memory = BaseUtils.getPropertyInt("memory", 512);
					if(System.getProperty("os.name").toLowerCase().startsWith("mac")){
						params.add("usr/bin/java");
					}else{
						params.add(System.getProperty("java.home")+"/bin/java");
					}
					if(System.getProperty("sun.arch.data.model").equals("64") && (memory<1024)) {
						memory = 1024;
						BaseUtils.setProperty("memory", memory);
					}
					params.add("-Xmx"+memory+"m");
					params.add("-XX:MaxPermSize=128m");

					if(System.getProperty("os.name").toLowerCase().startsWith("mac"))
					{
						params.add("-Xdock:name=Minecraft");
						params.add("-Xdock:icon="+BaseUtils.getAssetsDir().toString()+"/favicon.png");
					}
					params.add("-classpath");
					params.add(jarpath);
					params.add(Mainclass.class.getCanonicalName());
					params.add("true");

					ProcessBuilder pb = new ProcessBuilder(params);
					pb.directory(new File(BaseUtils.getAssetsDir().toString()));
					Process process = pb.start();
					if (process == null) throw new Exception("Launcher can't be started!");
					new ProcessUtils(process).print();
				}catch (Exception m){
					JOptionPane.showMessageDialog(Frame.main, e, "Ошибка запуска", javax.swing.JOptionPane.ERROR_MESSAGE, null);
					System.exit(0);
				}

		}
	}
}
