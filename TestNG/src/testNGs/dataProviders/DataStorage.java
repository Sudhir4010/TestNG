package testNGs.dataProviders;

import org.testng.annotations.DataProvider;

public class DataStorage {
	@DataProvider
	public String[][] loginData(){
		String data[][] = {
				{"admin", "admin"},
				{"ad", "admin"},
				{"admin", "ad"},
				{"ad", "ad"}
		};
		
		return data;
	}
	
	@DataProvider
	public String[][] registerData(){
		String registerData[][] = {
				{"kishan", "gupta", "kishangupta12345@gmail.com", "kishan@1234", "kishan@1234"},
				{"himanshu", "tiwari", "himanshu12345@gmail.com", "himanshu@1234", "himanshu@1234"},
				{"kishan", "gupta", "kishangupta1234@gmail.com", "kishan@1234", "kishan@1234"},
				{"sudhir", "chauhan", "sudhir1234@gmail.com", "sudhir@1234", "kishan@1234"},
				{"sushi", "raja", "sushil1234@gmail.com", "sushil@1234", "sushil@1234"}
		};
		
		return registerData;
	}
}
