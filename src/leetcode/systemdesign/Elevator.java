package leetcode.systemdesign;

import java.util.Arrays;
import java.util.LinkedList; 
import java.util.Queue;
 

public class Elevator {

	int[] layer;
	
	int floor = 0; //current floor
	Status status = Status.Stop; //running status
	
	Queue<Request> pendingRequest = new LinkedList<>();	
	public Elevator(int totalLayer) {		
		layer = new int[totalLayer];
	}
	
	
	public void Request(Request r)
	{
		if(isOnTheWay(r)){
			layer[r.from] = 1;
			layer[r.to] = 1;
		}
		else{
			pendingRequest.offer(r);//keep for next round
		}
	}
	
	 
	public void move(){
		if(status == Status.Down && floor >=  0)
			floor--;
		if(status == Status.Up && floor <= layer.length - 1)
			floor++;
		
		System.out.println("Move to " + floor);
		
		try {
			Thread.sleep(1);//Move simulation
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Change direction
		if(floor == 0 || floor == layer.length - 1){
			Arrays.fill(layer, 0);
			uTurn();
		}		
	}
	
	private void uTurn(){
		
		if(status == Status.Up)
			status = Status.Down;
		else if(status == Status.Down)
			status = Status.Up;
		
		Arrays.fill(layer, 0);
		//Fill layer array from pending request
		int size = pendingRequest.size();
		for(int i = 0; i < size; i++){
			Request request = pendingRequest.poll();
			
			if (isOnTheWay(request)){
				layer[request.from] = 1;
				layer[request.to] = 1;
			}
			else{
				pendingRequest.offer(request);//re-queue
			}
		}
	}
	
	public int findNextStopLayer(){
		if (status == Status.Up){
			for (int i = floor; i < layer.length; i++){
				if (layer[i] == 1)
					return i;
			}
			
			status = Status.Stop;
		}
		else if (status == Status.Down){
			for (int i = floor; i >= 0; i--){
				if (layer[i] == 1)
					return i;
			}

			status = Status.Stop;
		}
		else {//When stop, find the nearest one
			int top = Integer.MAX_VALUE;
			for (int i = floor; i < layer.length; i++){
				if (layer[i] == 1){
					top = i;
					break;
				}
			}
			
			int bottom = Integer.MIN_VALUE;
			for (int i = floor; i >= 0; i--){
				if (layer[i] == 1){
					bottom = i;
					break;
				}		
			}
			
			if (top == Integer.MAX_VALUE && bottom == Integer.MIN_VALUE){
				return -1;
			}
			else if (top == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE){
				status = top == Integer.MAX_VALUE ? Status.Down : Status.Up; 
			}
			else if (Math.abs(top - floor) < Math.abs(floor - bottom)){
				status = Status.Up;
			}
			else{
				status = Status.Down;
			}			
		}
		
		return -1; //no request
	}
	
	private boolean isOnTheWay(Request r){
		if((status == Status.Up && r.from > floor)
			|| (status == Status.Down && r.from < floor)){
			return true;
		}
		return false;	
	}
	
	
	
	public static void main(String[] args) {
		Elevator elevator = new Elevator(10);		
		ElevatorUser user = new ElevatorUser(elevator);
		new Thread(new ElevatorController(elevator)).start();
		user.Request(new Request(1, 9));
	}
}

enum Status {
	Stop,
	Up,
	Down
}

class Request {
	public int from = 0;
	public int to = 0;
	public Request(int f, int t){
		this.from = f;
		this.to = t;
	}
}

class ElevatorController implements Runnable {
	
	private Elevator elevator;	
	public ElevatorController(Elevator e){
		this.elevator = e;
	}
	
	@Override
	public void  run() {
		while (true) {
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));		
			try {				
				while (this.elevator.findNextStopLayer() != -1) {
					this.elevator.move();					
				}
				
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class ElevatorUser {
	private Elevator elevator;
	
	public ElevatorUser(Elevator e){
		this.elevator = e;
	}
	
	public void Request(Request r){
		this.elevator.Request(r);
	}
}
