package study_designPattern.singleton;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}//보일러가 비어있을 때만 돌아갑니다.
	
	public static synchronized ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}
	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
		}
	}//보일러에 우유/초콜렛을 혼합한 재료를 집어넣
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			empty = true;
		}
	}//끓인 재료를 다음 단계로 넘
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
	public boolean isEmpty() {
		return empty;
	}
	public boolean isBoiled() {
		return boiled;
	}
}
