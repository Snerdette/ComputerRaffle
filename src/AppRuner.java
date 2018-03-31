import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppRuner {

	static List<Winner> winnerList = new ArrayList<>();
	Excel userExcel = new Excel();
	static ArrayList<String> userList = (ArrayList<String>) Excel.getData("/Users/klafrance/Desktop/Computer wipe/Entries Final.xlsx");
	Excel computerExcel = new Excel();
	static ArrayList<String> computerList =(ArrayList<String>)(Excel.getData("/Users/klafrance/Desktop/Computer wipe/Computers.xlsx"));

	
	public static void main(String args[]) throws Exception {
		
		AppRuner app = new AppRuner();
		Raffle();
		WriteToFile writing = new WriteToFile();
	}
	
	static void Raffle(){
		
		for(int i = 1; i < computerList.size()-1; i++){
			
			Winner winner = new Winner();
			String username = getWinnerEmail();
			String id = computerList.get(i);
			
			winner.setId(id);
			winner.setUsername(username);

			winnerList.add(winner);
		}
	}
	
	static String getWinnerEmail(){

		int rand = RandomInteger(0, userList.size()-1);
		String email = userList.get(rand);
		
		return email;
		
	}
	
	public static int RandomInteger(int min, int max) {
		
	    Random rand = new Random();
	    int randomNum = min + (int)(Math.random() * ((max - min) + 1));
	    
	    return randomNum;
	}

}
