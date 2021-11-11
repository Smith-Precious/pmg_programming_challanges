package pmg_challenge;

/* Generate an interface that represents a "message" between systems that will have varying concrete implementations. 
 * Your code will include a way to "listen to a message" and "return status code"
 *  side note:  I was not too sure what the prompt was asking so the interface is very basic. 
 *  			I am not too familiar with interfaces as a whole so I will try and answer the questions listed at the end to the best of my ability and knowledge.
 * */

interface ScamCall {
	void automatedCalls(int i);

	void contiunedTalking(int j);
}

interface HouseFly {
	void landsOnYou(int xTimes);

	void landsOnLaptop(int yTimes);
}

class Workday implements ScamCall, HouseFly {

	@Override
	public void landsOnYou(int xTimes) {
		System.out.println("The Housefly landed on me " + xTimes + " through the day.");

	}

	@Override
	public void landsOnLaptop(int yTimes) {
		System.out.println("The Housefly landed on my laptop " + yTimes + " through the day.");
	}

	@Override
	public void automatedCalls(int i) {
		System.out.println("I recieved " + i + " scam calls today.");
	}

	@Override
	public void contiunedTalking(int j) {
		System.out.println("Scam callers kept talking for " + j + " minutes.");
	}
}

public class arch_challange {

	public static void main(String[] args) {
		Workday monday = new Workday();
		monday.automatedCalls(12);
		monday.contiunedTalking(7);
		monday.landsOnYou(3);
		monday.landsOnLaptop(73);
	}

}
/* Questions 3 - 6:
 * 
 * 3. Here I have created 2 interfaces, ScamCall & HouseFly, which are implemented in the Workday class.
 * 		Each interface contains 2 methods that pertain to what the interface created does.
 * 		Each interface consist of an integer that represents the number of times the method happens.
 * 	  class Workday 
 * 		each method implemented from the interfaces is called & enacted
 *    arch_challenge class
 * 		creates an instance of workday that calls on the methods and sets the integer values
 * 
 * 4. I am not familiar with deploying a platform in a public cloud. 
 * 
 * 5. The two types of MVPs that I think would work best are split testing and incremental development.  
 * 		The incremental development process breaks it into small portions that build until the final product is achieved. In order to be an MVP, the small increments would
 * 		not be the best option. If we are able to start with a basis and have each iteration build upon what we already have, we will have an MVP that is deployable with better features each time
 *		Split testing  is comparing versions of the same thing and seeing which is better based on consumer feedback. The only way I can see this being the best s if the versions being compared are closer to being completed
 *		and ready for consumer use. This method does present us with an easier means of improvement based ff of metrics and consumer choice which would be the overall goal.
 *
 * 
 * 6. The best way to divvy tasks to a team is based on the skills and abilities possessed on a team. 
 * 		Different team members will have different strengths and weaknesses and it is important to divide work accordingly and efficiently. Although
 * 		in most situations, this may not always be the case. There may be multiple team members good at one thing and weaker in the area assigned. In this case,
 * 		tasks can be split by who knows or is more experienced with the certain task presented.
 * 		From past experiences I learned that outlining what needs to be done and creating a timetable help keep a team on track. 
 * 		This also keeps track of what each team member is doing and if some task may take longer than others.
 * 		
 * 	  
 * 
 * */

