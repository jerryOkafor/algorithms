const insert = (array, rightIndex, value) => {
    var rightIndex;

    for (var i = rightIndex; i >= 0 && array[i] > value; i--) {
        array[i + 1] = array[i];
        rightIndex = i;
    }

    array[rightIndex] = value;

    // return array
};

module.exports = insert