package easy;
//剔除相邻的重复数组

public class test {


    public static void main(String[] strs){

//        int[] nums ={1,1,2};
        int[] nums =    {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("=====" + nums[i]);
        }
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

//    public static int removeDuplicates(int[] nums) {
//        for(int i=1;i<nums.length;i++){
//            if(nums[i] == nums[i-1]){
//                for (int j = i; j < nums.length -1; j++) {
//                    if (nums[j] <= nums[j+1]) {
//                        nums[j] = nums[j]^nums[j+1];
//                        nums[j+1] = nums[j]^nums[j+1];
//                        nums[j] = nums[j]^nums[j+1];
//                    }
//                }
//                i--;
//            }else if (nums[i] < nums[i -1]){
//                return i;
//            }
//        }
//        return  1;
//    }
}
