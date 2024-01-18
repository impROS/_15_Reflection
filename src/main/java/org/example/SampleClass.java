package org.example;

public class SampleClass {
    public String publicField="publicField";
    private int privateField;
    public static final String CONSTANT = "constant";

    private void privateMethod() {
        System.out.println("Özel metot çağrıldı.");
    }

    public void publicMethod() {
        System.out.println("Genel metot çağrıldı.");
    }
}
