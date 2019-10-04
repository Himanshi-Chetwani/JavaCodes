import java.sql.Timestamp;
import java.util.*;

public class TestSetInterface extends TestCollections {
    long st, ed;
    Timestamp start, end;
    private static final int upperLimit = 1000000;
    private static final int colCount = 2;
    private static Set<Integer>[] sets = new Set[colCount];
    private Random random = new Random();

    void printSortResult(boolean sorted) {
        if (sorted) {
            System.out.println("Test: sort successful");
        }
    }
    void sortSetFunction(List<Integer> sortSet) {
        Collection firstSort, secondSort;
        Collections.sort(sortSet);
        firstSort = sortSet;
        Collections.shuffle(sortSet);
        Collections.sort(sortSet, Comparator.comparingInt(o -> o));
        secondSort = sortSet;
        printSortResult(checkSortCollections(firstSort, secondSort));
    }


    /**
     * Compares two collection objects
     *
     * @param comapareList  list to compare
     * @param compareToList list to compare with
     * @return true if lists are equal
     */
    boolean checkSortCollections(Collection comapareList,
                                 Collection compareToList) {
        return comapareList.equals(compareToList);
    }
    void testSetSort(){
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int i = 0; i < upperLimit; i++) {
            List<Integer> sortHashSet = new ArrayList<>(sets[0]);
            sortSetFunction(sortHashSet);
        }
        System.out.println("Hash Set");
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int i = 0; i < upperLimit; i++) {
            List<Integer> sortTreeSet = new ArrayList<>(sets[1]);
            sortSetFunction(sortTreeSet);
        }
        System.out.println("Tree Set");
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);

    }
    void testAllMethods() {

        sets[0] = new HashSet<>();
        sets[1] = new TreeSet<>();
        for(int i=0;i<10;i++){
            sets[0].add(random.nextInt()/upperLimit);
            sets[1].add(random.nextInt()/upperLimit);
        }
        testSetSort();
    }
}