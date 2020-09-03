var merge = require('./mergeSort/mergeSort').merge
var sortWithMerge = require('./mergeSort/mergeSort').sortWithMerge

var array = [3, 7, 12, 14, 2, 6, 9, 11];
merge(array, 0,
    Math.floor((0 + array.length - 1) / 2),
    array.length - 1);
console.log("Array after merging: " + array);