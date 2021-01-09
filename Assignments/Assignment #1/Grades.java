//Ali Akbari Computer Science 233 L01
//Instructor :Leonard Manzara
//TA: Edwin Chan
//This program is designed to get an average of collected grades
//Also has some other statistics, such as Max/Min

import java.util.Scanner;

public class Grades {
	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);				//Using scanner to get input
	System.out.println("What's the course code?");		
	
	int c = input.nextInt();							//c is assigned to whatever course code input
	
	int numberOfentries = 0;							//Initialization number of entries
	int g = 0;											//Initialization g, used as grade input
	int allGradevalue = 0;								//Initialization sum of all grades variable
	int maxg = 0;										//Initialization maximum grade
	int ming = 100;										//Initialization minimum grade

	//Initialization of grade counters
	int letterAcounter = 0;								
	int letterAminusCounter = 0;
	int letterBplusCounter = 0;
	int letterBcounter = 0;
	int letterBminusCounter = 0;
	int letterCplusCounter = 0;
	int letterCcounter = 0;
	int letterCminusCounter = 0;
	int letterDplusCounter = 0;
	int letterDcounter = 0;
	int letterFcounter = 0;
	
	//Initialization of course average letter
	String courseAvgletter = null;
	//Initialization  of grade average
	double average = 0;
	
	//do while loop is used to use expression (!= -1) effectively
	//as -1 is sentinel value
	do {
		System.out.println("Type and enter grades one by one, enter -1 to finish and calculate average & other stats");
		
		@SuppressWarnings("resource")
		Scanner grades = new Scanner(System.in);
		g = grades.nextInt();
		
		if ((maxg < g) & (g <=100)){						//Finding Maximum
			maxg = g;
		}		
		if ((ming > g) & (g >=0)){							//Finding Minimum
			ming = g;		
		}
		
		//Range for each letter counter
		//letter counter is a statistic to check amount of letters corresponding to number of entries.
		if ((g >= 90) & (g <=100)){							
			letterAcounter ++;
		}	
		if ((g >= 85) & (g <90)){
			letterAminusCounter ++;
		}
		if ((g >= 80) & (g < 85)){
			letterBplusCounter ++;
		}
		if ((g >= 75) & (g <80)){
			letterBcounter ++;
		}
		if ((g >= 70) & (g < 75)){
			letterBminusCounter ++;
		}
		if ((g >= 65) & (g < 70)){
			letterCplusCounter ++;
		}	
		if ((g >= 60) & (g < 65)){
			letterCcounter ++;
		}
		if ((g >= 55) & (g < 60)){
			letterCminusCounter ++;
		}
		if ((g >= 50) & (g < 55)){
			letterDplusCounter ++;
		}
		if ((g >= 45) & (g < 50)){
			letterDcounter ++;
		}
		if ((g >= 0) & (g < 45)){
			letterFcounter ++;
		}
		
		if ((g >= 0) & (g<=100)){					//if statement checks if grade is in realistic range from 0 to 100
			numberOfentries ++ ;					//incrementing number of entries by 1
			allGradevalue = allGradevalue + g;		//every time a grade is entered it is summed up to allGradevalue 
		}	
		
		//this else if statement is only executed when the user is done entering  grades, then entering -1
		//-1 is the sentinel value to calculate average and other statistics
		else if ((g == -1) & (numberOfentries  != 0)){
			average = ((double)allGradevalue / numberOfentries);				//calculating average grade in double type

			//print statement to console for statistics
			System.out.println("Statistics of course " + c);
			System.out.println("The Number of Entries was " + numberOfentries);
			System.out.println("Total grades summed up " + allGradevalue );
			System.out.println("The maximum/highest grade was " + maxg);
			System.out.println("The minimum/lowest grade was " + ming);
			System.out.println("The average of the course " + c + " is "  + average);
			
			//Range of letter Averages, used to calculate over all letter grade
			if ((average >= 90) & (average <=100)){
				courseAvgletter = "A";
			}	
			if ((average >= 85) & (average <90)){
				courseAvgletter = "A-";
			}
			if ((average >= 80) & (average < 85)){
				courseAvgletter = "B+";
			}
			if ((average >= 75) & (average <80)){
				courseAvgletter = "B";
			}
			if ((average >= 70) & (average < 75)){
				courseAvgletter = "B-";
			}
			if ((average >= 65) & (average < 70)){
				courseAvgletter = "C+";
			}	
			if ((average >= 60) & (average < 65)){
				courseAvgletter = "C";
			}
			if ((average >= 55) & (average < 60)){
				courseAvgletter = "C-";
			}
			if ((average >= 50) & (average < 55)){
				courseAvgletter = "D+";
			}
			if ((average >= 45) & (average < 50)){
				courseAvgletter = "D";
			}
			if ((average >= 0) & (average < 45)){
				courseAvgletter = "F";
			}
			
			//print statements to console for statistics of table
			//including the letters and the amount 
			System.out.println("Average Grade letter of " + courseAvgletter);
			System.out.println("Letters       Amount               ");
			System.out.println("A              "+letterAcounter        );
			System.out.println("A-             "+letterAminusCounter   );
			System.out.println("B+             "+letterBplusCounter    );
			System.out.println("B              "+letterBcounter        );
			System.out.println("B-             "+letterBminusCounter   );
			System.out.println("C+             "+letterCplusCounter    );
			System.out.println("C              "+letterCcounter        );
			System.out.println("C-             "+letterCminusCounter   );
			System.out.println("D+             "+letterDplusCounter    );
			System.out.println("D              "+letterDcounter        );
			System.out.println("F              "+letterFcounter        );
						
				
		}
	}	
	while(g != -1);		//to break out of the loop, -1 must be entered, program exites if -1 is 
						//entered first and no calculations are done
	input.close();		//closes object input 
	
	}					
}
