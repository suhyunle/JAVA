import Vending;

public class VendingMain {
    public static void main(String[] args) {
        VendingMachineApp app = Vending.builder()
                                    .build() ; 
        app.init("switch");
    }
}
