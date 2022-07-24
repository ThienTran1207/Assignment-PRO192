import java.io.*;
import java.lang.*;
import java.util.*;

public class Menu<E> {
    public int int_getChoice(ArrayList<E> options){
        int response;
        int N = options.size();
        for (int i = 0; i <= N; i++){
            if(options.get(i)!=null){
                System.out.println((i+1) + ": " + options.get(i));
            }
        }
        response = MyLibs.inputInt();
        return response;
    }
    public E ref_getChoice(ArrayList<E> options){
        int response;
        int N = options.size();
        do {            
            response = int_getChoice(options);
        } while (response < 0 || response > N);
        return options.get(response - 1);
    }
}
