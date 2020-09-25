/* MERGE(A, p, q, r)
n1 = q - p + 1
n2 = r - q

//create temporary arrays
Let L[n1] and R[n2] be new arrays.

//Copy data to temporary arrays L[] and R[]
for i = 1 to n1
        L[i] = A[p + i]

for j = 1 to n2
        R[j] = A[q + 1 + j];

//Merge the temp arrays back into A[p..r]
i = 0; // Initial index of first subarray 
j = 0; // Initial index of second subarray 
k = p; // Initial index of merged subarray
while i < n1 && j < n2  
        if L[i] <= R[j]
            A[k] = L[i];
i++;  
        else
A[k] = R[j];
j++;
k++;

//Copy the remaining elements of L[], if any
while i < n1
        A[k] = L[i];
i++;
k++;

//Copy the remaining elements of R[], if any
while j < n2
        A[k] = R[j];
j++;
k++; */

/* MERGE - SORT(A, p, r)
1.   if p < r                      //check for base case - opposite of p≥r: the base case for subarray with just one element
2.        q ← ⌊(p + r) / 2⌋        //divide
3.        MERGE - SORT(A, p, q)     //conquer
4.        MERGE - SORT(A, q + 1, r) //conquer
5.        MERGE(A, p, q, r)       //combine 
*/

/* 
Takes in an array that has two sorted subarrays
from [low..mid] and [mid+1..high], and merges the array 
to have an array [low..high] that is sorted
*/
const merge = (array, low, mid, high) => {
    var leftHalf = []
    var rightHalf = []

    var k = low //k will grow from 0..array.lenght or high
    var i, j

    //fill left half with values from low..mid
    for (i = 0; k <= mid; i++, k++) {
        leftHalf[i] = array[k]
    }

    //file the rightHalf with values from mid+1 to high
    for (j = 0; k <= high; j++, k++) {
        rightHalf[j] = array[k]
    }

    //reset to begin merging
    k = low
    i = 0
    j = 0

    var leftHalfLenght = leftHalf.length
    var rightHalfLenght = rightHalf.length

    //Repeatedly compare the lowest untaken elements in leftHalf with
    //the lowest untaken element in the rightHalf and copy the lowest of the two back into the main array
    //increment the corresponding counter i or j

    while (i < leftHalfLenght && j < rightHalfLenght) {
        if (leftHalf[i] < rightHalf[j]) {
            array[k] = leftHalf[i]
            i++
        } else {
            array[k] = rightHalf[j]
            j++
        }
        k++
    }

    //Once one of the halves has been fully copied back into the main array
    //copy the raminaing elements from the other temporary array back into the main array

    //copy the ramaining elements of the leftHalf if any
    while (i < leftHalfLenght) {
        array[k] = leftHalf[i]
        i++
        k++
    }

    //copy the remaining elements of the rightHalf if any
    while (j < rightHalfLenght) {
        array[k] = rightHalf[j]
        j++
        k++
    }
}

const mergeSort = (array, p, r) => {
    if (p < r) {
        var q = Math.floor((p + r) / 2)
        mergeSort(array, p, q)
        mergeSort(array, q + 1, r)
        merge(array, p, q, r)
    }

}

const sortWithMerge = (array) => {
    var p = 0
    var r = array.length - 1

    mergeSort(array, p, r)
}

module.exports = {
    merge,
    sortWithMerge
}