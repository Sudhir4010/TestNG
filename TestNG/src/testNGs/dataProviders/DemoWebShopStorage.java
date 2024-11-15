package testNGs.dataProviders;

import org.testng.annotations.DataProvider;

public class DemoWebShopStorage {
	@DataProvider
	public String[][] dataSender(){
		String data[][] = {
				{"abhis1234@gmail.com", "abhis@1234"},
				{"ad", "abhis@1234"},
				{"abhis1234@gmail.com", "ad"},
				{"ad", "ad"}
		};
		
		return data;	
	}
}
