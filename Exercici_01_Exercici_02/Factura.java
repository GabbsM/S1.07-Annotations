package Exercici_01_Exercici_02;
/*
1) Creu una jerarquia d'objectes Java on els objectes fill sobreescriguin alguna funcionalitat de l'objecte pare
  emprant @Override.Afegeixi una classe que efectuï les invocacions necessàries demostrant el punt anterior.

2) Afegeixi a les classes fills alguns mètodes deprecados, i utilitzi la anotacion corresponent.
Invoqui des d'una classe externa els mètodes deprecados, suprimint mitjançant l'anotació corresponent
els warnings per ser deprecada la seva utilització.
 */



// Creamos clase factura con un constructor al que solicitamos por parámetro una cantidad de tipo double.
public class Factura {
    double cantidad;
    public Factura(double cantidad){
        this.cantidad = cantidad;

    }

    //Método getter que nos devuelve la cantidad.
    public double getCantidad(){
        return cantidad;
    }

}

// Clase FacturaIVA que hereda de Factura, donde agregamos la variable IVA.

class FacturaIVA extends Factura{
    double iva;
    public FacturaIVA(double cantidad) {
        super(cantidad);
    }

    // Construimos un método "test" al que indicamos como deprecado.
    @Deprecated public void test(){
        System.out.println("Método test deprecado");
    }


    //Método getter sobreescrito que nos calcula y nos suma el IVA a la cantidad de nuestra factura.
    public double getCantidad(){
        iva = cantidad*21;
        double ivaTotal = iva/100;
        return ivaTotal + cantidad;
    }

    public static void main(String[] args) {
        System.out.println();
        //Instanciamos objeto Factura y llamamos al getter original.
        Factura fact1 = new Factura(320.45);
        System.out.println("La factura es de " + fact1.getCantidad() + " euros");


        //Instanciamos objeto FacturaIVA usando la herencia y llamamos al getter sobreescrito.
        Factura fact2 = new FacturaIVA(320.45);
        System.out.println("La factura con IVA es de " + fact2.getCantidad() + " euros");

        //Instanciamos objeto de clase hija y llamamos a método depracado. Imprimimos que el método está
        // depracado.
        FacturaIVA fact3 = new FacturaIVA(12);
        fact3.test();
    }
}
