public class sort {
  public void selectSort(int[] nums) {
    int len = nums.length;
    int minIndex = 0;
    //int temp = 0;

    for (int i = 0; i < len; i++) {
      minIndex = i;
      for (int j = i + 1; j < len; j++) {
        minIndex = nums[j] < nums[minIndex] ? j : minIndex;
      }

      int temp = nums[i] ^ nums[minIndex];
      nums[i] = nums[i] ^ temp;
      nums[minIndex] = nums[minIndex] ^ temp;
    }
  }

  public void insertSort(int[] nums) {
    int len = nums.length;
    int preIndex;
    int current;

    for (int i = 1; i < len; i++) {
      preIndex = i - 1;
      current = nums[i];
      while (preIndex >= 0 && nums[preIndex] > current) {
        nums[preIndex + 1] = nums[preIndex];
        preIndex--;
      }

      nums[preIndex + 1] = current;
    }
  }

  public void bubbleSort(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; j < len - 1 - i; j++) {
        int temp = nums[j] ^ nums[j + 1];
        nums[j] = nums[j] ^ temp;
        nums[j + 1] = nums[j + 1] ^ temp;
      }
    }
  }
}
