package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SurpriseReflectionExample {

    public static void main(String[] args) throws Exception {
        // Reflection ile bir örnek sınıf oluşturalım
        SampleClass sampleObject = new SampleClass();

        // Özel alanın değerini değiştirelim
        Field privateField = SampleClass.class.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.set(sampleObject, 42);

        // Özel metodu çağıralım
        Method privateMethod = SampleClass.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(sampleObject);

        // Sınıfın alanlarını ve metotlarını yazdıralım
        printClassDetails(sampleObject);

        SampleClass sampleObject2 = new SampleClass();
        System.out.println((sampleObject2.publicField));

        Field publicField = SampleClass.class.getDeclaredField("publicField");
        publicField.set(sampleObject2, "publicFieldAfterReflection");
        System.out.println((sampleObject2.publicField));


    }

    // Sınıfın alanlarını ve metotlarını yazdıran yardımcı bir metod
    private static void printClassDetails(Object obj) {
        Class<?> classObj = obj.getClass();

        System.out.println("Sınıf Adı: " + classObj.getName());

        System.out.println("\nSınıf Alanları:");
        for (Field field : classObj.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println("Alan Adı: " + field.getName() + ", Değeri: " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nSınıf Metotları:");
        for (Method method : classObj.getDeclaredMethods()) {
            System.out.println("Metot Adı: " + method.getName());
        }
    }
}


