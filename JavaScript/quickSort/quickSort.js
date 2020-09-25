/* 
1. QuickSort uses divid and conquer - a recusive algorithm just like mergeSort
2. In mergeSort, the divide step does hardly anything, all the real work happens 
    in the conbine step. QuickSort is the opposite, all the real work happens in the divide step and the combine
    step does nothing mush
3. Quicksort works in place while MergeSort does not. 
4. It's worst-case running time is as bad as selection sort's and insertion sort's big-Θ(n^2).
    But its average-case running time is as good as merge sort's big-Θ(nlog(n))

    Why QuickSort:
    1. The constant factor hidden in the big-Θ notation for quicksort is quite good.
    2. In practice, quicksort outperforms merge sort and it significantly outperforms selction and insertion sort.
*/


/* 
Here the actual work is done.
Partition subarray[p..r] around a pivete drawn from the subarray.
Although, we can choose any element in the subarray as the pivot, it's easy to implement
partition if we choose the rightmost element of the subarray, arr[r] as the pivot.

Partition the subarray by going through it from left to right.
Groups:
    1. L - arr[p..q-1] - elements know to be less than on equal to the pivot.
    2. G - arr[q..j-1] - elements know to be greater than the pivot.
    3. U - arr[j..r-1] - elements whose relationship to the pivot is unknown, because they have not yet been completed
    4. P - array[r] - the pivot
*/

//Swaps two items in an array changing the original array
const swap = (array, firstIndex, secondIndex) => {
    let temp = array[firstIndex]
    array[firstIndex] = array[secondIndex]
    array[secondIndex] = temp
}

/* 
Compare array[j] with array[r], for j = p, p+1,...r-1 maintaining that:
array[p..q-1] are values known to be <= to array[r]
array[q..j-1] are values known to be > array[r]
array[j..r-1] haven't been compared with array[r]
If array[j] > array[r], just increment j.
If array[j] <= array[r], swap array[j] with array[q],increment q, and increment j.
Once all elements in array[p..r-1]
have been compared with array[r],
swap array[r] with array[q], and return q. 
*/
const partition = (array, p, r) => {
    let q = p

    for (let j = p; j <= r - 1; j++) {
        if (array[j] <= array[r]) {
            swap(array, j, q)
            q++
        }
    }
    swap(array, r, q)

    return q
}

const quickSort = (array, p, r) => {
    if (p < r) {
        let q = partition(array, p, r)
        quickSort(array, p, q - 1)
        quickSort(array, q + 1, r)
    }
}

const sortWithQuickSort = (array) => {
    let p = 0;
    let r = array.length - 1

    quickSort(array, p, r)
}

module.exports = {
    partition,
    sortWithQuickSort
}