const insert = (array, rightIndex, value) => {
    let leftIndex;
    for (leftIndex = rightIndex; leftIndex >= 0 && array[leftIndex] > value; leftIndex--) {
        array[leftIndex + 1] = array[leftIndex];
    }

    array[leftIndex + 1] = value;
};

const insertionSort = (array) => {
    for (let i = 1; i < array.length; i++) {
        insert(array, i - 1, array[i])
    }
}

module.exports = {
    insert,
    insertionSort
}