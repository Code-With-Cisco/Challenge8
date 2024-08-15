
package challenge8;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author 5767275
 * Professor Charters
 * COP 3804
 * Adopt-A-Pet Final Challenge
 */
public class Challenge8 {
   
    public static PriorityQueue<Pet> animalShelter = new PriorityQueue<>();
    public static LinkedList<Pet> catsLL = new LinkedList<>();
    public static LinkedList<Pet> dogsLL = new LinkedList<>();
    public static Stack<Long> microchipStack = new Stack<>();
    public static Scanner scnr = new Scanner(System.in);
    
    
   
    
    public static void main(String[] args) {      
         int menuOption;
          do
          {
             menuOption = showMenu();
             switch (menuOption) {
                 case 0 -> pushMicroChip();
                 case 6 -> showPets();
                 case 1 -> donateCat();
                 case 2 -> donateDog();
                 case 5 -> adoptOldest();
                 case 4 -> adoptADog();
                 default -> {
                 }
             }
          } while (menuOption != 7);
         
    }
    
        public static void pushMicroChip()
    {
        //Generate 100 Long random numbers using System.nanotime(),
        //and add them to the Microchips Stack.
        if(!microchipStack.empty()){
        System.out.println("Are you sure you want to enter More MicroChips? ");
        String userInput = scnr.next();
            while(userInput.equalsIgnoreCase("yes"))
            {
                for(int i = 0; i < 100; i++)
                {
                    microchipStack.push(System.nanoTime());
                }
                System.out.println("you have added 100 microchips.");
                break;
            }
        }
        else 
        {
            for(int i = 0; i < 100; i++)
            {
                microchipStack.push(System.nanoTime());
            } 
            System.out.println("you have added 100 microchips.");
        }
    }
    public static void adoptADog()
    {
               /* 
                0. if peek at the dog linked list and its null,
                say to user no dog available to adopt and exit method
                otherwise there are dog in the linked list
                1. take out the first dog from the dog linked list (removeFirst() )
                * 
                1.5 create a temporary priority queue
                2. do while loop (while PriorityQueue is NOT empty)
                check if pet from the priority queue matches the pet from dog linked list
                if it does NOT, put the pet in a temporary priority queue
                else if does match, do not put pet into temporary priority queue
                3. point the animal shelter queue to the temporary priority queue
                */
{
        if(dogsLL.peek() == null)
        {
            System.out.println("There are no dogs to adopt");
        }
        else
        {
            Pet adoptedDog = dogsLL.poll();
            System.out.println("The dog you addopted id " + adoptedDog);
            animalShelter.remove(adoptedDog);  
        }
		}
            }
                public static void donateDog()
            {
           /*     
            0. check if the microchip stack is empty
            otherwise get the next avilable microchip from stack of microchips
            if it is tell the user to go back and do option 0
            1. ask user for the name of the cat
            2. hard code "dog" as the species
            use try catch and do while
            3. ask user for dob, validate year <= 2022 & >= 2000
            ask month 1-12
            ask day 1-31
            concatenate yyyymmdd into a string
            parse the string into an int
            4.) put pet object into 2 places: dog linkedList and animalshelterqueue
            */
    {
        DecimalFormat df = new DecimalFormat("00");
        int year = 0 ,month = 0,day = 0;
        if(microchipStack.empty() == true)
        {
            System.out.println("Please add more microChips");           
        }
        else
        {
            System.out.println("What is your dog name");
            String name = scnr.next();
            String species = "dog";
            boolean error = false;
            do
            {
                do
                {    
                    try 
                    {
                        System.out.println("What year was your dog year of birth? (YYYY)");
                        year = scnr.nextInt();
                        error = false;
                        while(year > 2022 || year < 2000)
                        {
                            System.out.println("Your animal can't have been born that year please enter a new year");
                            scnr.nextLine();
                            year = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What month was your dog born? (mm)");
                    try
                    {
                        month = scnr.nextInt();
                        error = false;
                        while(month < 1 || month > 12)
                        {
                            System.out.println("Please enter a valid month. ");
                            scnr.nextLine();
                            month = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What Day was your dog born? (dd)");
                    try
                    {
                        day = scnr.nextInt();
                        error = false;
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid day. ");
                            scnr.nextLine();
                            day = scnr.nextInt();
                            error = false;
                    
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                String yr = String.valueOf(year);
                String mth = df.format(month);
                String dy = df.format(day);
                String date = (yr + mth + dy);
                int dateOfBirth = Integer.parseInt(date);
                long chips = microchipStack.pop(); 
                Pet dog = new Pet(name, dateOfBirth, species, chips);
                dogsLL.add(dog);
                animalShelter.add(dog); 
            }while(error);
            }
            }
            }
                        
                        
            public static void adoptACat(){
               /* 
                0. if peek at the cat queue and its null,
                say to user no cats available to adopt and exit method
                otherwise there are cats in the linked list
                1. take out of the cat LinkedList the first one in it
                1.5 create a temporary priority queue
                2. do while loop
                a.) remove  the pet from the cat linked list
                b.) check if pet matches the same pet from cat linked list
                if it does not, put the pet in a temporary priority queue
                else if does match, do not put pet into temporary priority queue
                3. point the animal shelter queue to the temporary priority queue
                */
 {
        if(catsLL.peek() == null)
        {
            System.out.println("There are no cats to adopt");
        }
        else
        {
            Pet adoptedCat = catsLL.poll();
            System.out.println("the cat you addopted is " + adoptedCat);
            animalShelter.remove(adoptedCat);
        }
            }
            }

    public static void adoptOldest()
    {
        /**
         *             
           1. take the pet out of the animal shelter priority queue
           (Remove it!)
           * 
           2.) if animal shelter priority queue is empty, say "sorry shelter is currently empty"
         
           3.) look at the species of the animal that you retrieved from priority queue and find 
                   the animal in the cat or the dog linkedList
                   take the pet out of its corresponding linkedList  (cat or dog)
                   (Use an iterator to traverse thru LinkedList using next() in a 
                   while (it.hasNext()) loop.  If the Pet traversed with next() is the one
                   * you removed from the AnimalShelter Priority Queue, then also remove it
                   * from the LinkedList.                  
         */
                boolean found = false, isCat = false;
		PriorityQueue <Pet> tmp = new PriorityQueue<>();

		if (animalShelter.isEmpty())
			System.out.println("No pet available atm");
		else {
			while (!catsLL.isEmpty() && found == false) {
				if (catsLL.peek().equals(animalShelter.peek())) {
					System.out.println(animalShelter.remove());
					catsLL.remove();
					tmp.addAll(catsLL);
					catsLL.clear();
					catsLL.addAll(tmp);
					found = true;
					isCat = true;
				} else {
					tmp.add(catsLL.peek());
					catsLL.remove();
				}
				if (catsLL.isEmpty()) {
					catsLL.addAll(tmp);
					found = true;
				}
			}
			tmp.clear();
			found = false;
			while (!dogsLL.isEmpty() && found == false && isCat == false) {
				if (dogsLL.peek().equals(animalShelter.peek())) {
					System.out.println(animalShelter.remove());
					dogsLL.remove();
					tmp.addAll(dogsLL);
					dogsLL.clear();
					dogsLL.addAll(tmp);
					found = true;
				} else {
					tmp.add(dogsLL.peek());
					dogsLL.remove();
				}
				if (dogsLL.isEmpty()) {
					dogsLL.addAll(tmp);
					found = true;
				}
			}
		}
    }
    
    public static void donateCat()
    {
        /**
         *    
            0. check if the microchip stack is empty
            if it is tell the user to go back and do option 0
            .5 Pop the microchip stack 
            1. ask user for the name of the cat
            2. hard code "cat" as the species
            use try catch and do while
            3. ask user for dob, validate year <= 2022 & >= 2000
            ask month 1-12
            ask day 1-31
            concatenate yyyymmdd into a string
            parse the string into an int
            3.5  create a Pet object with all the data
            4.) put pet object into 2 places: cat linkedList and animalshelter priority queue
            addLast for the cat linkedList; add to animalShelter Priority Queue (based upon Pet's compareTo)
         */
 {
        DecimalFormat df = new DecimalFormat("00");
        int year = 0 ,month = 0,day = 0;
        if(microchipStack.empty() == true)
        {
            System.out.println("Please add more microChips");           
        }
        else
        {
            System.out.println("What is your cat name");
            String name = scnr.next();
            String species = "cat";
            boolean error = false;
            do
            {
                do
                {    
                    try 
                    {
                        System.out.println("What year was your cat year of birth? (YYYY)");
                        year = scnr.nextInt();
                        error = false;
                        while(year > 2022 || year < 2000)
                        {
                            System.out.println("Your animal can't have been born that year please enter a new year");
                            scnr.nextLine();
                            year = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What month was your cat born? (mm)");
                    try
                    {
                        month = scnr.nextInt();
                        error = false;
                        while(month < 1 || month > 12)
                        {
                            System.out.println("Please enter a valid month. ");
                            scnr.nextLine();
                            month = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do  
                {
                    System.out.println("What Day was your cat born? (dd)");
                    try
                    {
                        day = scnr.nextInt();
                        error = false;
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid day. ");
                            scnr.nextLine();
                            day = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                String yr = String.valueOf(year);
                String mth = df.format(month);
                String dy = df.format(day);
                String date = (yr + mth + dy);
                int dateOfBirth = Integer.parseInt(date);
                long chips = microchipStack.pop(); 
                Pet cat = new Pet(name, dateOfBirth,species, chips);
                catsLL.add(cat);
                animalShelter.add(cat); 
            }while(error);
        }
    }
    }
    
    public static void showPets()
    {
        /**
            Display a message that this is the Animal Shelter Priority Queue,
            in order of birth date. Then, create a loop that will display all 
            the Pets in the Animal Shelter, a Priority Queue based upon the birth date of the Pet. You MUST use a loop to show the pets in the correct order (ascending by birth date).

            (Create a new PQ Animal Shelter; Loop to poll the Animal Shelter, print it,  & add to new PQ Animal Shelter.
            At the end of the loop, make the Original Animal Shelter PQ point to the new one.


            Then, display a message that states this is the Cat LinkedList, and 
            then display the LinkedList for Cats, which is in the order of arrival to animal shelter.
            Create an iterator for the Cat LinkedList. Use a while-loop testing it.hasNext(),
            jumping over each node with a next().  Print each node.

            Finally, display a message that states this is the Dog List, 
            and then display the LinkedList for Dogs, which is in the order of arrival to animal shelter.
         */
        System.out.println("Cat queue:");
	System.out.println(catsLL);
	System.out.println("Dog queue:");
	System.out.println(dogsLL);
	System.out.println("Priority queue:");
	System.out.println(animalShelter);
    }
    
    
    public static int showMenu()
    {
       /**  int option = -1;
        create a loop that will repeat until option entered is 7:
        Include a try-catch for non-numeric entries and for < 0 or > 7
        0. add new microchipps
        1. donate a cat
        2. donate a dog
        3. adopt a cat
        4. adopt a dog
        5. adopt oldest pet
        6. show pets
        7. exit
        * **/
        int option = -1;
        do
        {
            System.out.println("What would you like to do?");
            System.out.println("0 = Add new microchip");
            System.out.println("1 = Donate a cat");
            System.out.println("2 = Donate a dog");
            System.out.println("3 = Adopt a cat");
            System.out.println("4 = Adopt a dog");
            System.out.println("5 = Adopt oldest pet");
            System.out.println("6 = Show animals");
            System.out.println("7 = Exit");
            try
            {
                option = scnr.nextInt();
                switch(option)
                {
                    case 0 -> pushMicroChip();
                    case 1 -> donateCat();
                    case 2 -> donateDog();
                    case 3 -> adoptACat();
                    case 4 -> adoptADog();
                    case 5 -> adoptOldest();
                    case 6 -> showPets();
                    case 7 -> System.out.println("Thanks for visiting!");
                    default -> System.out.println("The number needs to be between 0 and 7.");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number 0 - 7");
                scnr.nextLine();
            }
        }while(option != 7 || option < 0 && option > 7);
        
        return 0;
    }
}

            
     


