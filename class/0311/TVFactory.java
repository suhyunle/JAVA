public interface TV{
  public void powerOn();

  public class TVFactory{ 
    private TV [] ary;
    private TVFactory(){
      ary = new TV[2];

    }

    public static TVfactory getnstance(){
      if(instance ==null ){
        instance = new TVFactory();

      }

      return instance;
    }

    public TV getBrand(String BrandName){
      TV tv=(brandName.equals("apple")) ? ary[0]:ary[1];

      return tv;

    }
  }
}


  
  
