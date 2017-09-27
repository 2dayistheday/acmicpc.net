package study_designPattern.singleton;

public class Singleton {
	private volatile static Singleton uniqueInstance;
	
	private Singleton() {}
	public static Singleton getInstance() {
		if(uniqueInstance == null) {//인스턴스가 있는지 확인하고 없으면 동기화된 블럭으로 들어갑니다.
			synchronized (Singleton.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}
