package com.thevarungupta.Day3;

public class Demo22 {
    public static void main(String[] args) {

        // Case 1 : Exception not occur
        try{
            int c = 10/5;
            System.out.println(c);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Case 1: finally called");
        }

        // Case 2 : Exception occur but not handled
        try{
            int c = 20/0;
            System.out.println(c);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Case 2: finally called");
        }

        // Case 3 : Exception occur and handled
        try{
            int c  =10/0;
            System.out.println(c);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Case 3: finally called");
        }
    }
}
