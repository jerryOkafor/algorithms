/* 
A Queue object for queue-like functionality over JavaScript arrays.
Note: This uses a constructot function
//Todo: Implement the same Queue class using es6
 */
var Queue = function () {
    this.items = [];
};
Queue.prototype.enqueue = function (obj) {
    this.items.push(obj);
};
Queue.prototype.dequeue = function () {
    return this.items.shift();
};
Queue.prototype.isEmpty = function () {
    return this.items.length === 0;
};

module.exports = Queue