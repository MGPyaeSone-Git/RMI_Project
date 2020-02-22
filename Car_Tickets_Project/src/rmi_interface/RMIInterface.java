package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {
	
	public Cars findCar(Cars cars) throws RemoteException;

	public List<Cars> allCars() throws RemoteException;
	
}
