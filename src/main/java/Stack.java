/**
 * Created by wesleybudding on 18/09/2017.
 */
public class Stack implements DoubleStack{
    int amountItems;
    private int numberOfElements = 0;
    private double[] item;


    Stack(){
        amountItems=5;
        item = new double[amountItems];
        numberOfElements = 0;
    }

    public void push(Double element) {
        item [numberOfElements]= element;
        numberOfElements++;
        if(element>numberOfElements){
            doubleStack();
        }
    }

    public void doubleStack(){
        double[] copyItem;
        copyItem = new double[amountItems];

        for(int n=0; n < numberOfElements; n++){
            copyItem[n] = item[n];
        }

        amountItems*=2;
        item = new double[amountItems];

        for(int n=0; n < numberOfElements; n++){
            item[n] = copyItem[n];
        }

    }

    public Double pop() {
        numberOfElements--;
        return item[numberOfElements];
    }

    public Double top() {
        return null;
    }

    public int size() {
        return 0;
    }
}
