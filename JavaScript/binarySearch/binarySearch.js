/* Returns either the index of the location in the array,
  or -1 if the array did not contain the targetValue */
const doSearch = (array, targetValue) => {
    var min = 0;
    var max = array.length - 1;
    var guess;

    while (min <= max) {
        guess = Math.floor(min + ((max - min) / 2));

        if (array[guess] === targetValue) {
            return guess;

        } else if (array[guess] < targetValue) {
            //adjust min
            min = guess + 1;
        } else {
            //adjust max
            max = guess - 1;
        }
    }

    return -1;
};

module.exports = doSearch