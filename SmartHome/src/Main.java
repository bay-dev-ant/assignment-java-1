/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bay
 */
import java.util.Scanner;

public class Main 
{
   
    //**Required arrays */
    static int[] watts=    {60 , 40 , 40 , 2000 , 1500 , 150 , 2000 , 120 , 10};
    static String[] names= {"Living Room Light" , "Kitchen Light" , "Bedroom Light" , "Heat Pump" , 
                            "Bedroom Heater" , "Fridge" , "Washing Machine" , "TV" , "Wi-Fi Router"};
    static String[] types= {"Light" , "Light" , "Light" , "Thermostat" , "Thermostat" , "Smart Plug" , "Smart Plug" , "Smart Plug" , "Smart Plug"};
    static boolean[] isON= {true , true , true , true , true , true , true , true , true};
    
    
    
    //*Main method*/
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int menuChoice;
        printMenu();                                       //Calls the method printMenu which in turn displays the main menu when the application is launched.
        menuChoice = readInt(in, 0, 5);                    //Assigns to menuChoice, which is used to
        while (menuChoice!= 0)
        {
            switch (menuChoice) 
            {
                case 1: 
                    printDevices();
                    break;
                case 2:
                    controlDevices(in);
                    break;
                case 3:
                    totalPower();
                    break;
                case 4:
                    toKWh(in);
                    break;
                case 5:
                    deviceMax(in);
                    break;
            }
            System.out.print("Choose: ");
            menuChoice = readInt(in, 0, 5);
        }
    }
    
    
 
/** Prints the application's control menu */
    public static void printMenu()
        {
                System.out.println("===== SMART HOME CONTROL PANEL =====\n1. Show devices\n2. Switch a device on/off\n3. Show total power\n4. Estimate today's cost\n5. Most powerful device ON\n0. Exit");
                System.out.print("Choose: ");
        }
    public static void printDevices()
    {
    
        for (int i=0; i< names.length; i++) 
        {
            System.out.println(i + "." + names[i] + "|" + watts[i] + "|" + isON[i]);
        }
    }
    public static void totalPower()
    {
        int allPower = 0; 
      for (int j=0; j< names.length; j++)                           //A loop from 1-9 to check which devices are ON
      {                                       
          if (isON[j] == true)
          {
            allPower = allPower + watts[j];                         //Calculates power based on working devices and prints it.
          } 
      }   
          System.out.println("Total power of devices that are ON: "+allPower+" Watts");
      }  
     public static void controlDevices(Scanner in)
     {
         System.out.print("Choose a device (1-9): ");            
         int dNum = readInt(in, 1, 9);                             // Changes the isOn array to false depending on user's input and reports.
         if (isON[dNum-1] == true)
         {
             isON[dNum-1] = false;
             System.out.println(names[dNum-1]+" is now OFF.");
         }
         else 
         {
             isON[dNum-1] = true;
             System.out.println(names[dNum-1]+" is now ON.");
         }
     }   
     public static void toKWh(Scanner in)
     {
         double totalEnergy = 0;
         double deviceEnergy = 0;
         for (int k = 0; k< names.length; k++)                                 
         {
           System.out.print("Enter the ammount of hours that "+names[k]+" was switched on today: ");
           double deviceHrs = in.nextDouble();
           deviceEnergy = watts[k]*deviceHrs/1000.0;
           totalEnergy = totalEnergy + deviceEnergy;
           
         }
         double totalCost = totalEnergy*0.20;
         System.out.printf("Today's projected energy consumption is %.2f kWh and the total cost is %.2f Euros.%n", totalEnergy, totalCost);
       }
     public static void deviceMax(Scanner in)
     {
       int max = 0;
       String mostPowerfulDevice = null;
       for (int i = 0; i < names.length; i++) 
       {
           if (watts[i] > max && isON[i] == true)
           {
             max = watts[i];
             mostPowerfulDevice = names[i];
           }
       }
       System.out.println("The most powerful working device at the moment is "+mostPowerfulDevice);
               
               
     }
     public static int readInt(Scanner in, int min, int max)
     {
       int menuChoice;
       do {
           menuChoice = in.nextInt();
           if (menuChoice < min || menuChoice > max)
           {
               System.out.print("Please enter a valid number: ");
           }
          } 
       while (menuChoice < min || menuChoice > max);
       return menuChoice;
      }
}

    

   
    

    
