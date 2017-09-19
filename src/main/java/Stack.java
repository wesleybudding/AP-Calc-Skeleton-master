/**
 * Created by wesleybudding on 18/09/2017.
 */
public class Stack implements DoubleStack{
    static final int MAX_ITEMS=100;
    private int elements = 0;
    private double item[];


    Stack(){
        item = new double[MAX_ITEMS];
        elements = 0;
    }

    public void push(Double element) {
        item [elements]= element;
        elements++;
    }

    public Double pop() {
        elements--;
        return item[elements];
    }

    public Double top() {
        return null;
    }

    public int size() {
        return 0;
    }
}
