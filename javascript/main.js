var merge = require('./mergeSort/mergeSort').merge
var sortWithMerge = require('./mergeSort/mergeSort').sortWithMerge

var partition = require('./quickSort/quickSort').partition
var Stack = require('./util/Stack')
// var array = [3, 7, 12, 14, 2, 6, 9, 11];
// merge(array, 0,
//     Math.floor((0 + array.length - 1) / 2),
//     array.length - 1);
// console.log("Array after merging: " + array);


// var array = [9, 7, 5, 11, 12, 2, 14, 3, 10, 4, 6];
// var q = partition(array, 0, array.length - 1);
// console.log("Array after partitioning: " + array);

let stack = new Stack()

stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)
stack.push(6)

stack.print()

console.log("Peeking")
console.log(stack.peek())
console.log(stack.isEmpty())
console.log("Length: ", stack.length)

console.log("Poppin")

console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())