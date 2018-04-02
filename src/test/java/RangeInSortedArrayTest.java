package test.java;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import main.java.RangeInSortedArray;
import org.junit.Test;

public class RangeInSortedArrayTest {
  private static final RangeInSortedArray rangeInSortedArray = new RangeInSortedArray();

  @Test
  public void checkForValueNotPresentInArray(){
    //given
    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 9;

    //when
    int[] result = rangeInSortedArray.searchRange(arr, target);

    //then
    assertThat(result, notNullValue());
    assertThat(result.length, equalTo(2));
    assertThat(result[0], equalTo(-1));
    assertThat(result[1], equalTo(-1));
  }

  @Test
  public void checkForValuePresentInArray(){
    //given
    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 8;

    //when
    int[] result = rangeInSortedArray.searchRange(arr, target);

    //then
    assertThat(result, notNullValue());
    assertThat(result.length, equalTo(2));
    assertThat(result[0], equalTo(3));
    assertThat(result[1], equalTo(4));
  }
}
