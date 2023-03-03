import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

interface MyInterface {
    String getId();
    Integer sum(Integer a,Integer b);
    Double divide(Double a, Double B) throws Exception;
    Date calcDate3DaysAgo();
    LocalTime avaysAdd3Hours(LocalDate inDate);
    void someMethodWithoutReturnData();
    void someMethodWithoutDataButHaveVariableNumbersOfArguments(String...varArgs);

}
// Define the custom annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Private {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Public {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ScanMe {}

@ScanMe
class class1 implements MyInterface {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}

class class2 implements MyInterface {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}

@ScanMe
class class3 implements MyInterface {
    @Override
    @Public
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}

class class4 implements MyInterface {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}


public class Main {
    public static void main(String[] args) {
        List<MyInterface> myObjectsToScan = new ArrayList<>();
        myObjectsToScan.add(new class1());
        myObjectsToScan.add(new class2());
        myObjectsToScan.add(new class3());
        myObjectsToScan.add(new class4());

        System.out.println("Classes annotated with @ScanMe:");
        for (MyInterface obj : myObjectsToScan) {
            Class<?> clazz = obj.getClass();
            if (clazz.isAnnotationPresent(ScanMe.class)) {
                System.out.println(clazz.getName());
            }
        }

        System.out.println("Methods annotated with @Private in classes annotated with @ScanMe:");
        for (MyInterface obj : myObjectsToScan) {
            Class<?> clazz = obj.getClass();
            if (clazz.isAnnotationPresent(ScanMe.class)) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Private.class)) {
                        System.out.println(clazz.getName() + "." + method.getName());
                    }
                }
            }
        }

        System.out.println("Methods without custom annotation in classes without @ScanMe annotation:");
        for (MyInterface obj : myObjectsToScan) {
            Class<?> clazz = obj.getClass();
            if (!clazz.isAnnotationPresent(ScanMe.class)) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(Private.class) && !method.isAnnotationPresent(Public.class)) {
                        System.out.println(clazz.getName() + "." + method.getName());
                    }
                }
            }
        }
        System.out.println("Scanned classes:");
        for (MyInterface obj : myObjectsToScan) {
            Class<?> clazz = obj.getClass();
            System.out.println("Class:");
            if(clazz.isAnnotationPresent(ScanMe.class)) {
                System.out.println("[ScanMe]");
            }
            System.out.println(clazz.getName());
            List<String> annoList = new ArrayList<>();
            List<String> methodsList = new ArrayList<>();
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods) {
                methodsList.add(method.getName());
                if(method.isAnnotationPresent(Private.class) && method.isAnnotationPresent(Public.class)) {
                    annoList.add("Private, Public");
                } else if(method.isAnnotationPresent(Private.class)) {
                    annoList.add("Private");
                } else if(method.isAnnotationPresent(Public.class)){
                    annoList.add("Public");
                } else {
                    annoList.add("");
                }
            }
        }
    }
}