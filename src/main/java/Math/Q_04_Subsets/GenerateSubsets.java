package Math.Q_04_Subsets;

import java.util.ArrayList;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 Note: 1) Elements in a subset must be in non-descending order. 2) The solution set must not contain duplicate subsets.

 For example, given S = [1,2,3], the method returns:
 [
   [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []

   for a set of n elements we can have 2^n subsets.
   Time complexity = 2^n
 ]
 */
public class GenerateSubsets {

    /**
     * Solution:
     *
     * Look at smaller subproblems
     * Set = [] subsets = [ [] ]
     * Set = [2] subsets = [ [], [2]]
     * Set = [2, 3] subsets = [ [], [2], [3], [2,3] ]
     * Set = [1,2,3] subsets = [ [], [2], [3], [2,3], [1], [2,1], [3,1], [2,3,1]]
     *
     * Note Set = [1,2,3] can be build from set [2, 3] by adding 1 to the previous subsets of [2, 3] + all previous subsets of [2, 3]
     * We can build a recursive algorithm based on this logic.
     *
     * @param setList
     * @return
     */
    public static ArrayList<ArrayList<Integer>> generateSubsets(final ArrayList<Integer> setList) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(setList.size() == 0) {
            return res;
        }
        return generate(res, setList);
    }

    private static ArrayList<ArrayList<Integer>> generate(final ArrayList<ArrayList<Integer>> res, final ArrayList<Integer> setList) {

        if(setList.isEmpty()) {
            //add an empty list, note an empty list is also one of the subsets
            ArrayList<Integer> subSetList = new ArrayList<Integer>();
            res.add(subSetList);
            return res;
        }

        //get the first item from the set
        int first = setList.get(0);

        //pass the remaining list recursively
        ArrayList<ArrayList<Integer>> resultList = generate(res, new ArrayList<Integer>(setList.subList(1, setList.size())));
        ArrayList<ArrayList<Integer>> modifiedList = addFirstElementInThePreviousSubList(resultList, first);

        return modifiedList;
    }

    private static ArrayList<ArrayList<Integer>> addFirstElementInThePreviousSubList(final ArrayList<ArrayList<Integer>> resultList, final int first) {
        ArrayList<ArrayList<Integer>> modifiedList = new ArrayList<ArrayList<Integer>>();

        for(ArrayList<Integer> subList : resultList) { //ex sublist = [ [2,3], [2], [3], []]  first = 1
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.addAll(subList); // newList = [[2,3]], [2]
            newList.add(first); // newList = [[2,3, 1]], [2,1]
            modifiedList.add(newList); // modifiedList = [ [2,3,1], [2,1]]
        }
        resultList.addAll(modifiedList);
        return resultList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(generateSubsets(list));
    }

}
