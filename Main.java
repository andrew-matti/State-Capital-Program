import java.util.*;

public class Main{
  public static void main(String[] args){
    //2-dimensial array of states and capitals
    //States = Row 0 and State Capitals= Row 1
    String[][] statecapitals= {
      { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida",
            "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
            "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
            "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" },
        { "Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee",
            "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort",
            "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City",
            "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck",
            "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville",
            "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne" }
    };
      //Ask for user input of a state capital
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a state capital: ");
    String Input= scanner.nextLine();
    boolean correct=false;
    /* Iterate through sub array of capitals (row 1) to find if user input is a match */
    String[] cities = statecapitals[1];
    for (String city:cities) {
      if(city.equalsIgnoreCase(Input)) {
        correct=true;
        break;
      }
    }
    //If user input correct then tell user
    if (correct == true) {
      System.out.println("Awesome! " + Input + " is a state capital.");
    }
    //if no match to user input then tell user they are wrong
    else
      System.out.println(Input + " is not a state capital.");
    // Part 1 print out 2-D array
    //Iterate through all elements in both sub arrays
    //Print States to corresponding Capital
    for (int a= 0; a <50; a++) {
      System.out.println("The state capital of " + statecapitals [0][a] + " is " + statecapitals[1][a] + ".");
    }
    //Bubble sort the 2D array by state capital
    System.out.println("Rearranging the arrary in alphabetical order by state capital.");
    //Iterate through for loop and nested for loop 
    for (int a= 0; a < statecapitals[0].length; a++) {
      for (int b = a + 1; b < statecapitals[0].length; b++){
        //Initialize variables for capital and state
        String tempCity;
        String tempState;
        //Use compareto function to alphabetized capitals
        if (statecapitals[1][b].compareTo(statecapitals[1][a]) < 0){
          //If true, swap the elements
          tempCity = statecapitals[1][a];
          statecapitals[1][a] = statecapitals [1][b];
          statecapitals[1][b] = tempCity;
          //do the same for corresponding states
          tempState =  statecapitals[0][a];
          statecapitals[0][a] = statecapitals [0][b];
          statecapitals[0][b] = tempState;
        }
      }
    }
    System.out.println("Now enter as many state capitals as you can. Enter 'quit' when you have finished.");
    //add array to store answers 
    boolean loop= false;
    Scanner loopscanner= new Scanner(System.in);
    ArrayList<String> inputlist = new ArrayList<>();
    //create while loop and take user input 
    while (!loop){
      String loopinput = loopscanner.nextLine();
      if (loopinput.equalsIgnoreCase("quit")){
        loop = true;
      }
    else {
      inputlist.add(loopinput);
    }
    }
    //Start a counter
    int answercounter = 0;
    // check each answer to see if it is a match in array
    for (String answer: inputlist) {
      for (String city : cities){
        if(answer.equalsIgnoreCase(city))
          answercounter += 1;
      }
    }
    // Display number of correct answers
    System.out.println(answercounter + " answers are correct!");
     // Create hashmap, state is key and capital is value
        HashMap<String, String> capitalcityMap = new HashMap<>(statecapitals[0].length);
        // Iterate through 2-D array 
        // Place Row 0 (state) and Row 1 (capital) values into HashMap
        for (int i = 0; i < statecapitals[0].length; i++) {
            capitalcityMap.put(statecapitals[0][i], statecapitals[1][i]);
        }
        // Print Hashmap
        System.out.println("Printing unsorted HashMap.");
        // Iterate through all keys, print the key and its corresponding value
        for (String key : capitalcityMap.keySet()) {
            System.out.println("The capital of " + key + " is " + capitalcityMap.get(key) + ".");
        }
        // Use the TreeMap class to sort the map while storing it in a binary tree
        TreeMap<String, String> capitals = new TreeMap<>(capitalcityMap);
        // Ask user for a state and return the state's capital
        System.out.println("Enter a state to find out it's state capital.");
        System.out.println("Enter the command 'quit' when finished.");
        // Initialize variable to start the loop
        boolean EndLoop = true;
        Scanner scanner= new Scanner(System.in);
        while (EndLoop) {
            // Take user input, checking to see if the user has quit
            System.out.println("Please enter a state: ");
            String loopInput = scanner.nextLine();
            if (loopInput.equalsIgnoreCase("quit")) {
                System.out.println("Terminating Program.");
                EndLoop = false;
                continue;
            }
            // If the user does not quit, check if the input exists as a key in the TreeMap and provide value (state)
            if (capitals.containsKey(loopInput)) {
                System.out.println("The capital of " + loopInput + " is " + capitals.get(loopInput) + ".");
            }
            else {
                System.out.println("Be sure to capitalize the first letter in each state name. Please try again, or type 'quit'.");
            }
        }
  }
}