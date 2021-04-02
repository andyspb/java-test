package com.gd;

import java.util.HashSet;
import java.util.Set;

// Find the duplicated elements from array ( result list cannot contain duplicated elements )
public class FindDupsInArray {

  public static void findDups1(int[] array) {
    Set<Integer> set = new HashSet<Integer>();

    for(int i = 0; i < array.length ; i++)
    {
      //If same integer is already present then add method will return FALSE
      if(set.add(array[i]) == false)
      {
        System.out.println("Duplicate element found : " + array[i]);
      }
    }

  }

  public static void main(String[] args)
  {
    int[] array = {1,1,2,3,4,5,6,7,8,8};
    findDups1(array);
  }

}
