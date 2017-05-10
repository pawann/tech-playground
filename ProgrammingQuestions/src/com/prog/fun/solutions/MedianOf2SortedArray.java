package com.prog.fun.solutions;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 */
public class MedianOf2SortedArray {

	public static void main(String[] args) {
		new MedianOf2SortedArray().findMedianSortedArrays(new int[]{1,3}, new int[]{2});
		new MedianOf2SortedArray().findMedianSortedArrays(new int[]{1,3,5}, new int[]{2,4});
		new MedianOf2SortedArray().findMedianSortedArrays(new int[]{1,3,5}, new int[]{2,4,6});
		//new MedianOf2SortedArray().findMedianSortedArrays(new int[]{}, new int[]{});
		new MedianOf2SortedArray().findMedianSortedArrays(new int[]{}, new int[]{1});
		//new MedianOf2SortedArray().findMedianSortedArrays(null, null);



	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int arr1Len = nums1 != null ? nums1.length : 0;
    	int arr2Len = nums1 != null ? nums2.length : 0;
    	
    	if(arr1Len == 0 && arr2Len == 0)
    		return 0;
    	
    	int i1 = 0;
    	int i2 = 0;
    	
    	int medianIdx = (arr1Len + arr2Len)/2 + 1;
    	//System.out.println("MedianIndex: "+medianIdx);
    	int prevNum = 0;
    	int currNum = 0;
    	int iteration = 1;
    	while(iteration <= medianIdx){
    		int n1 = i1<arr1Len ? nums1[i1] : Integer.MAX_VALUE;
    		int n2 = i2<arr2Len ? nums2[i2] : Integer.MAX_VALUE;
    		
    		prevNum = currNum;
    		
    		if( n1 < n2 ){
    			currNum = n1;
    			i1++;
    		} else {
    			currNum = n2;
    			i2++;
    		}
    		iteration++;
    	}
    	
    	double median = 0;
    	if( (arr1Len + arr2Len)%2 == 0 ){
    		//Even
    		median = (prevNum + currNum)/2d;
    	} else {
    		median = currNum;
    	}
    	//System.out.println("Median -->"+ median +", itr:"+(iteration-1));
        return median;
    }
    
}
