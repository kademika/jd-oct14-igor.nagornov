package Tanks.TanksOOP.Service;

public interface Destroyable{
	
	void destroy() throws InterruptedException, Exception;
	boolean isDestroyed();

}
