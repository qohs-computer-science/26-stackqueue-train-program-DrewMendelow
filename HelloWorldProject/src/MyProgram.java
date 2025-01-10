/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);

			Queue<Train> carList = new LinkedList<Train>();
			String line = x.nextLine();
			
			while (!line.equals("END")){
				if (line.length() > 2 && line.substring(0,3).equals("CAR")){
					String name = line;
					String product = x.nextLine();
					String origin = x.nextLine();
					String destination = x.nextLine();
					int weight = x.nextInt();
					int miles = x.nextInt();
					boolean isEngine = false;
					Train newCar = new Train(name, product, origin, destination, weight, miles, isEngine);
					carList.add(newCar);
					// System.out.println(newCar.getName() + ", " + newCar.getProduct() + ", " + newCar.getOrigin() + ", " + newCar.getDestination() + ", " + newCar.getWeight() + ", " + newCar.getMiles() + ", " + newCar.getIsEngine() + ", ");
				}
				else if (line.length() > 2 && line.substring(0,3).equals("ENG")){
					String name = line;
					String destination = x.nextLine();
					boolean isEngine = true;
					Train newCar = new Train(name, "", "", destination, 0, 0, isEngine);
					carList.add(newCar);
				}
				line = x.nextLine();
			}
			
			Stack<Train> Bal = new Stack<Train>();
			int BalWeight = 0;

			Stack<Train> Char = new Stack<Train>();
			int CharWeight = 0;

			Stack<Train> Tren = new Stack<Train>();
			int TrenWeight = 0;

			Stack<Train> Other = new Stack<Train>();
			int OtherWeight = 0;

			Queue<Train> reviewList = new LinkedList<Train>();

			while (carList.size() > 0){
				Train car = carList.remove();
				if (!car.getIsEngine()){
					if (car.getMiles() > 700){
						reviewList.add(car);
					}
					else{
						if (car.getDestination().toLowerCase().equals("baltimore")){
							if (BalWeight < limitTrackC){
								Bal.push(car);
							}
							else{
								//SEND OF ENG0000 for Bal
								Bal.push(car);
							}
						}
						else if (car.getDestination().toLowerCase().equals("charlotte")){
							if (CharWeight < limitTrackB){
								Char.push(car);
							}
							else{
								//SEND OF ENG0000 for Char
								Char.push(car);
							}
						}
						else if (car.getDestination().toLowerCase().equals("trenton")){
							if (TrenWeight < limitTrackA){
								Tren.push(car);
							}
							else{
								//SEND OF ENG0000 for Tren
								Tren.push(car);
							}
						}
						else{
							Other.push(car);
						}
					}
				}
				else{
					//DEPART track with car destination field
				}
			}

			while (reviewList.size() > 0){
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
