package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * reflection, bir sınıfın veya nesnenin yapısal bilgilerine (alanlar, metotlar, arayüzler vb.)
 *  dinamik olarak erişmeyi sağlayan bir mekanizmadır.
 */
public class Main {
    public static void main(String[] args) {
        SampleClass sampleObject = new SampleClass();

        Class<?> classObj = sampleObject.getClass();
        System.out.println("Sınıf Adı: " + classObj.getName());

        Field[] fields = classObj.getDeclaredFields();
        System.out.println("\nSınıf Alanları:");
        for (Field field : fields) {
            System.out.println("Alan Adı: " + field.getName() + ", Türü: " + field.getType());
        }

        Method[] methods = classObj.getDeclaredMethods();
        System.out.println("\nSınıf Metotları:");
        for (Method method : methods) {
            System.out.println("Metot Adı: " + method.getName() + ", Dönüş Türü: " + method.getReturnType());

//invoke methodu ile private metotlara erişebiliriz.
            if (method.getName().equals("privateMethod")) {
                try {
                    method.setAccessible(true);//private metotlara erişebilmek için yoksa =>
                    // example.Main cannot access a member of class org.example.SampleClass with modifiers "privat
                    // hatası alırdık
                    method.invoke(sampleObject);//private metot çağrıldı.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
