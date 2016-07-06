package config;

public class ApplicationConfiguration {
//	static{
//		instance = new ApplicationConfiguration();
//	}
	private static ApplicationConfiguration instance = new ApplicationConfiguration();
	private ApplicationConfiguration() {
		
	}
	public boolean getJPanelDoubleBuffered() {
		return true;
	}

	public static ApplicationConfiguration getInstance() {
		return instance;
	}
	public int getDefaultNumbersOfColumns(){
		return 8;
	}
}
