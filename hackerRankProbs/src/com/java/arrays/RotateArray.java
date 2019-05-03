package com.java.arrays;
class RotateArray 
{
    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n) 
    {
        int i;
        for (i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
          // rightRotatebyOne(arr, n);
    }
 
    void leftRotatebyOne(int arr[], int n) 
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++){
           arr[i] = arr[i + 1];
        }           
        arr[i] = temp;
        //System.out.println(arr[i]);
    }
 
    /*void rightRotatebyOne(int[] nums, int k) {
       int temp, previous;
       for (int i = 0; i < k; i++) {
           previous = nums[nums.length - 1];
           for (int j = 0; j < nums.length; j++) {
               temp = nums[j];
               nums[j] = previous;
               previous = temp;
           }
       }
   }*/
 
    /* utility function to print an array */
    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotate.leftRotate(arr, 3, 7);
        rotate.printArray(arr, 7);
        System.out.println("");
       // rotate.rightRotatebyOne(arr, 3, 7);
        System.out.println("");
        
    }
}