import java.util.Arrays;
import java.util.List;

interface FuncInterface
{
    void multiply(int x);
}

public class LambdaStreams {

	public static void main(String[] args) {
		
		FuncInterface fobj = (int x)->System.out.println(2*x);
        // This calls above lambda expression and prints 10.
        fobj.multiply(5);
		
		//stream api map() and filter() methods example
		List<Integer> numbers= Arrays.asList(3,2,5,6,1);
		System.out.print("List after multiplying by 2: \t");
		numbers.stream().map(n->n*2).forEach(n-> System.out.print("\t"+ n));
		System.out.print("\n\nEven numbers in the list are: \t");
		numbers.stream().filter(n->n%2==0).forEach(n-> System.out.print("\t"+ n));	
		
	}
}
