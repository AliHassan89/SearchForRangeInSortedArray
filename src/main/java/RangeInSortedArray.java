/**

 Given an array of integers sorted in ascending order, find the starting and ending position of a
 given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 */

package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    int len = nums.length;
    if (len == 0 ||
        nums[0] > target ||
        nums[0] < target && nums[len-1] < target)
      return result;

    int index = binarySearch(nums, target);
    if (index == -1)
      return result;

    List<Integer> listResult = new ArrayList<>();
    while (index > 0 && nums[index-1] == target)
      index--;

    listResult.add(index);

    while (index < len && nums[index] == target)
      index++;

    listResult.add(--index);

    int[] ret = new int[listResult.size()];
    Iterator<Integer> iterator = listResult.iterator();
    for (int i = 0; i < ret.length; i++)
    {
      ret[i] = iterator.next().intValue();
    }

    return ret;
  }

  private int binarySearch(int[] nums, int target){
    int mid = nums.length / 2;
    if (nums[mid] == target)
      return mid;

    int p1 = 0;
    int p2 = nums.length - 1;

    while (p1 <= p2){
      mid = (p1 + p2) / 2;
      if (nums[mid] == target)
        return mid;
      if (nums[mid] < target)
        p1 = mid + 1;
      else
        p2 = mid - 1;
    }

    return -1;
  }
}
