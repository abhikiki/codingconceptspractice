import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sample {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(20);
        nums.add(10);
        nums.add(5);
        Collections.sort(nums, (n1, n2) -> n2.compareTo(n1));
        Collections.reverse(nums);

        nums.stream().forEach(num -> System.out.println(num));
    }
}
