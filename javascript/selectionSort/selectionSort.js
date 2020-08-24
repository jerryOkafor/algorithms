/*
Selection sort loops over positions in the array. For each position,
it finds the index of the minimum value in the subarray starting at that position.
Then it swaps the values at the position and at the minimum index.
Write selection sort, making use of the swap and indexOfMinimum functions.
*/

var swap = (array, firstIndex, secondIndex) => {
    var temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
};

var indexOfMinimum = (array, startIndex) => {

    var minValue = array[startIndex];
    var minIndex = startIndex;

    for (var i = minIndex + 1; i < array.length; i++) {
        if (array[i] < minValue) {
            minIndex = i;
            minValue = array[i];
        }
    }
    return minIndex;
};


const selectionSort = (array) => {

    //Loop over solution in array
    for (var i = 0; i < array.length; i++) {

        //find the index of the minimum value in subarray for i.. index positions
        var indexOfMinValue = indexOfMinimum(array, i);

        //swap value at i with value at [indexOfMinvalue]
        swap(array, i, indexOfMinValue);
    }

    return array

}

module.exports = selectionSort