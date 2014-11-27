package lesson5.video9Upcasting;

public class Musician {
	
	public void play(Instrument i){
		
		i.sound();	//
		if(i instanceof Guitar){ //proveryaem yavlyaetsya li instument guitaroy
			Guitar g = (Guitar)i; //procast objecta i klassa Instrument v object Guitar
			g.testMessage(); //esli procast ne sdelat', to method testMessage budet nedostupen, potomu chto 
		}									//v klasse Instrument net takogo methoda
			
	}

}
