var merge = require('./mergeSort/mergeSort').merge
var sortWithMerge = require('./mergeSort/mergeSort').sortWithMerge

var partition  = require('./quickSort/quickSort').partition

// var array = [3, 7, 12, 14, 2, 6, 9, 11];
// merge(array, 0,
//     Math.floor((0 + array.length - 1) / 2),
//     array.length - 1);
// console.log("Array after merging: " + array);


var array = [9, 7, 5, 11, 12, 2, 14, 3, 10, 4, 6];
var q = partition(array, 0, array.length - 1);
console.log("Array after partitioning: " + array);