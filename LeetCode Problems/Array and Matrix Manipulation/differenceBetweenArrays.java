class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        ArrayList<List<Integer>> output = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        Stack<Integer> removeValues = new Stack<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        for(int i = 0; i < len1; i++){
            if(!list1.contains(nums1[i])){
                list1.add(nums1[i]);
            }
        }

        for(int i = 0; i < len2; i++){
            if(!list2.contains(nums2[i])){
                if(list1.contains(nums2[i])){
                    removeValues.push(nums2[i]);
                }
                else{
                    list2.add(nums2[i]);
                }
            }
        }

        while(!removeValues.empty()){
            list1.remove(removeValues.pop());
        }

        output.add(list1);
        output.add(list2);

        return output;
    }
}