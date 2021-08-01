package kuaipai;
//单例模式
public class Singleton {
    private Singleton(){};
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("单例模式测试");
    }
}
