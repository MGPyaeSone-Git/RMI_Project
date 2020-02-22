package rmi_server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import rmi_interface.Cars;
import rmi_interface.RMIInterface;

public class CarsStore extends UnicastRemoteObject implements RMIInterface {
	private static final long serialVersionUID = 1L;
	private List<Cars> carsList;

	protected CarsStore(List<Cars> list) throws RemoteException {
		super();
		this.carsList = list;
	}

	@Override
	public Cars findCar(Cars cars) throws RemoteException {
		// TODO Auto-generated method stub
		Predicate<Cars> predicate = x -> x.getBus_id().equals(cars.getBus_id());
		return carsList.stream().filter(predicate).findFirst().get();
	}

	@Override
	public List<Cars> allCars() throws RemoteException {
		// TODO Auto-generated method stub
		return carsList;
	}

	private static List<Cars> initializeList() {
		List<Cars> list = new ArrayList<>();
		list.add(new Cars("Bus_1", "00001", "A-1", "1:00-PM"));
		list.add(new Cars("Bus_2", "00002", "A-2", "2:00-PM"));
		list.add(new Cars("Bus_3", "00003", "A-3", "3:00-PM"));
		list.add(new Cars("Bus_4", "00004", "A-4", "4:00-PM"));
		list.add(new Cars("Bus_5", "00005", "A-5", "5:00-PM"));
		list.add(new Cars("Bus_6", "00006", "A-6", "6:00-PM"));
		return list;
	}

	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/MyCarStore", new CarsStore(initializeList()));
			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.getMessage());
		}
	}

}
