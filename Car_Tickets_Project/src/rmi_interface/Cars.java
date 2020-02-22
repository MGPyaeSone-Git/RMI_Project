package rmi_interface;

import java.io.Serializable;

public class Cars implements Serializable {

	private static final long serialVersionUID = 1190476516911661470L;
	private String bus_name;
	private String bus_id;
	private String bus_seat_no;
	private String departure_time;

	public Cars(String bus_id){
		this.bus_id = bus_id;
	}
	
	public Cars(String bus_name, String bus_id, String bus_seat_no, String departure_time) {
		super();
		this.bus_name = bus_name;
		this.bus_id = bus_id;
		this.bus_seat_no = bus_seat_no;
		this.departure_time = departure_time;
	}

	public String getBus_name() {
		return bus_name;
	}

	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getBus_seat_no() {
		return bus_seat_no;
	}

	public void setBus_seat_no(String bus_seat_no) {
		this.bus_seat_no = bus_seat_no;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String toString(){
		return "> " + this.bus_name + " | " + this.bus_id + " | " + this.bus_seat_no + " | " + this.departure_time;
	}

}
