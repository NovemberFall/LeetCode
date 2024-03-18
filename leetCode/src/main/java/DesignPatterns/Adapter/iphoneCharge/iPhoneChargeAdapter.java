package DesignPatterns.Adapter.iphoneCharge;

// Target interface
interface IPhone {
    public void OnCharge();
}

// Implement the Adaptee class:
// This class represents the existing component with an incompatible interface.
// So this is the IPhone4s charger that your friend has .
class Iphone4sCharger implements Charger {
    Iphone4sCharger() {
    }

    public void charge() {
        System.out.println("charging with 4s charger");
    }
}


interface Charger {
    public void charge();
}

// Create the Adapter class:
// The Adapter class implements the Target interface and internally uses an instance of the Adaptee class.
// It adapts the Adaptee’s interface to match the Target interface by delegating the calls appropriately.
// So here we will use an IPhone4s to IPhone6s adapter so that we can easily charge our IPhone6s .
class Iphone4sTo6sAdapter implements Charger {
    Iphone4sCharger iphone4sCharger;

    Iphone4sTo6sAdapter() {
        iphone4sCharger = new Iphone4sCharger();
    }

    @Override
    public void charge() {
        iphone4sCharger.charge();
    }
}

// Connect the client code to the Adapter:
// Instantiate the Adapter class and use it as a bridge between the client code and the Adaptee.
// So here you will connect your IPhone6s to IPhone4s Charger to charge your phone .
class IPhone6s implements IPhone {
    Charger Iphone4sTo6sAdapter;

    public IPhone6s(Charger iphone4sTo6sAdapter) {
        this.Iphone4sTo6sAdapter = iphone4sTo6sAdapter;
    }

    @Override
    public void OnCharge() {
        Iphone4sTo6sAdapter.charge();
    }
}

class iPhoneChargeAdapter {
    public static void main(String[] args) {
        IPhone6s iphone6s = new IPhone6s(new Iphone4sTo6sAdapter());
        iphone6s.OnCharge();
    }
}
