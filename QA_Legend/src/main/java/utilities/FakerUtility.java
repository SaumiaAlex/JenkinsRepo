package utilities;

import java.util.Random;

public class FakerUtility 
{
 public int randomNumberCreation()
 {
	 Random random = new Random();
	 int randomNumber = random.nextInt(10000);
	 return randomNumber;
 }
}
