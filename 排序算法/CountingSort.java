public class CountingSort {
    // 伪计数排序
    public void countingSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int minValue = nums[0], maxValue = nums[0];
        for (int x : nums) {
            if (x > maxValue) maxValue = x;
            else if (x < minValue) minValue = x;
        }
        int[] cnt = new int[maxValue - minValue + 1];
        for (int x : nums) {
            cnt[x - minValue]++;
        }
        for (int i = 0, j = 0; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                nums[j++] = i + minValue;
                cnt[i]--;
            }
        }
    }

    // 真正的计数排序
    public void countingSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int minValue = nums[0], maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxValue) maxValue = nums[i];
            else if (nums[i] < minValue) minValue = nums[i];
        }
        int[] cnt = new int[maxValue - minValue + 1];
        for (int x : nums) {
            cnt[x - minValue]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[--cnt[nums[i] - minValue]]] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main() {

    } 
}