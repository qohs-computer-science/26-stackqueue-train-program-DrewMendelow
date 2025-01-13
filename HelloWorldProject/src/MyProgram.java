/*
 * Drew Mendelow
 * 1/13/25
 * pd 7
 * Sorts all the incoming train cars at a station and then redirects them to the correct track.
 * Tracks will be sent off when the weight gets to large for an engine and cars going to places 
 * not on the tracks will be put on the other track.
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
				}//end if
				else if (line.length() > 2 && line.substring(0,3).equals("ENG")){
					String name = line;
					String destination = x.nextLine();
					boolean isEngine = true;
					Train newCar = new Train(name, "", "", destination, 0, 0, isEngine);
					carList.add(newCar);
				}//end else if
				line = x.nextLine();
			}//end while
			
			Stack<Train> Bal = new Stack<Train>();
			int BalWeight = 0;

			Stack<Train> Cha = new Stack<Train>();
			int ChaWeight = 0;

			Stack<Train> Tre = new Stack<Train>();
			int TreWeight = 0;

			Stack<Train> Other = new Stack<Train>();

			Queue<Train> reviewList = new LinkedList<Train>();

			while (carList.size() > 0){
				Train car = carList.remove();
				if (!car.getIsEngine()){
					if (car.getMiles() > 700){
						reviewList.add(car);
					}//end if
					else{
						if (car.getDestination().toLowerCase().equals("baltimore")){
							if (BalWeight + car.getWeight() < limitTrackC){
								Bal.push(car);
							}//end if
							else{
								departTrain(Bal, car.getDestination());
								BalWeight = 0;
								Bal.push(car);
							}//end else
							BalWeight += car.getWeight();
						}//end if
						else if (car.getDestination().toLowerCase().equals("charlotte")){
							if (ChaWeight + car.getWeight() < limitTrackB){
								Cha.push(car);
							}//end if
							else{
								departTrain(Cha, car.getDestination());
								ChaWeight = 0;
								Cha.push(car);
							}//end else
							ChaWeight += car.getWeight();
						}//end else if
						else if (car.getDestination().toLowerCase().equals("trenton")){
							if (TreWeight + car.getWeight() < limitTrackA){
								Tre.push(car);
							}//end if
							else{
								departTrain(Tre, car.getDestination());
								TreWeight = 0;
								Tre.push(car);
							}//end else
							TreWeight += car.getWeight();
						}//end else if
						else{
							Other.push(car);
						}//end else
					}//end else
				}//end if
				else{
					Stack<Train> train = new Stack<Train>();
					if (car.getDestination().toLowerCase().equals("baltimore")){
						train = Bal;
						BalWeight = 0;
					}//end if
					else if (car.getDestination().toLowerCase().equals("charlotte")){
						train = Cha;
						ChaWeight = 0;
					}//end else if
					else if (car.getDestination().toLowerCase().equals("trenton")){
						train = Tre;
						TreWeight = 0;
					}//end else if
					departTrain(train, car.getDestination(), car.getName());
				}//end else
			}//end while

			if (BalWeight > 0){
				departTrain(Bal, "Baltimore");
				BalWeight = 0;
			}//end if

			if (ChaWeight > 0){
				departTrain(Cha, "Charlotte");
				ChaWeight = 0;
			}//end if

			if (TreWeight > 0){
				departTrain(Tre, "Trenton");
				TreWeight = 0;
			}//end if

			while (reviewList.size() > 0){
				Train car = reviewList.remove();
				car.setMiles(100);
				if (car.getDestination().toLowerCase().equals("baltimore")){
					if (BalWeight + car.getWeight() < limitTrackC){
						Bal.push(car);
					}//end if
					else{
						departTrain(Bal, car.getDestination());
						BalWeight = 0;
						Bal.push(car);
					}//end else
					BalWeight += car.getWeight();
				}//end if
				else if (car.getDestination().toLowerCase().equals("charlotte")){
					if (ChaWeight + car.getWeight() < limitTrackB){
						Cha.push(car);
					}//end if
					else{
						departTrain(Cha, car.getDestination());
						ChaWeight = 0;
						Cha.push(car);
					}//end else
					ChaWeight += car.getWeight();
				}//end else if
				else if (car.getDestination().toLowerCase().equals("trenton")){
					if (TreWeight + car.getWeight() < limitTrackA){
						Tre.push(car);
					}//end if
					else{
						departTrain(Tre, car.getDestination());
						TreWeight = 0;
						Tre.push(car);
					}//end else
					TreWeight += car.getWeight();
				}//end else if
				else{
					Other.push(car);
				}//end else
			}//end while

			if (BalWeight > 0){
				departTrain(Bal, "Baltimore");
				BalWeight = 0;
			}//end if

			if (ChaWeight > 0){
				departTrain(Cha, "Charlotte");
				ChaWeight = 0;
			}//end if

			if (TreWeight > 0){
				departTrain(Tre, "Trenton");
				TreWeight = 0;
			}//end if

			System.out.println("Cars left in the Other track:");
			while(Other.size() > 0){
				Train car = Other.pop();
				System.out.println(car.getName() + " containing " + car.getProduct());
			}//end while
		}//end try
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}//end catch
	}//end main

	public static void departTrain(Stack<Train> engine, String city){
		System.out.println("ENG00000 leaving for " + city + " with the following cars:");
		while (engine.size() > 0){
			Train car = engine.pop();
			System.out.println(car.getName() + " containing " + car.getProduct());
		}//end while
		System.out.println();
	}//end departTrain

	public static void departTrain(Stack<Train> engine, String city, String name){
		System.out.println(name + " leaving for " + city + " with the following cars:");
		while (engine.size() > 0){
			Train car = engine.pop();
			System.out.println(car.getName() + " containing " + car.getProduct());
		}//end while
		System.out.println();
	}//end departTrain
}//end class
